package ru.neshin.posta.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "batch")
public class Batch {
    @Id
    @GeneratedValue
    @Column(name = "batch_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    /**
     * Номер партии
     */
    private String name;

    @Column(name="status")
    /**
     * Статусы партии
     */
    private BatchStatus batchStatus;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Archive> archives;
}
