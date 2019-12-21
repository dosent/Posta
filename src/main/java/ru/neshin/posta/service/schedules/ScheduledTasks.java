package ru.neshin.posta.service.schedules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.neshin.posta.service.ArchiveService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    private ArchiveService archiveService;

    @Value("${updates.enabled}")
    private boolean enabledScheduled;

    @Autowired
    public ScheduledTasks(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "${updates.time}")
    public void reportCurrentTime() {
        if (enabledScheduled) {
            archiveService.updateArchiveFromPochtaRu();
            LOGGER.info("The time is refresh {}", dateFormat.format(new Date()));
        }
    }
}
