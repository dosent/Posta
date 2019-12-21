package ru.neshin.posta.model.listeners;

import ru.neshin.posta.model.Archive;

import javax.persistence.PrePersist;

public class ArchiveEntityListeners {

    @PrePersist
    public void setCustomHash(Archive archive) {
        archive.setHash(archive.getCustomHash());
    }
}