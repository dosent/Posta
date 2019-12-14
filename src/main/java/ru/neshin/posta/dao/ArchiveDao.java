package ru.neshin.posta.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.neshin.posta.model.Archive;

import java.util.Optional;

@Repository
public interface ArchiveDao extends CrudRepository<Archive, Long> {
    Optional<Archive> findById(Long id);

    Optional<Archive> findByBatchName(String batch);
}
