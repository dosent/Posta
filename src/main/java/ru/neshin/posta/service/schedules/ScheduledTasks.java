package ru.neshin.posta.service.schedules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.neshin.posta.service.ArchiveService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    private ArchiveService archiveService;

    @Autowired
    public ScheduledTasks(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        archiveService.updateArchiveFromPochtaRu();
        LOGGER.info("The time is now {}", dateFormat.format(new Date()));
    }
}
