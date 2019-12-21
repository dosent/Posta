package ru.neshin.posta.controllers;

import ru.neshin.posta.dto.ArchiveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neshin.posta.service.ArchiveService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("archive")
public class ArchiveController {
    private ArchiveService archiveService;

    @Autowired
    public ArchiveController(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }

    @GetMapping("{id}")
    public ArchiveDto get(@PathVariable(name = "id") @NotNull Long id) {
        return archiveService.getId(id);
    }
}
