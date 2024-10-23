package com.cka.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.domain.Persistable;

import java.io.Serial;
import java.io.Serializable;

/**
 * A Authority.
 */
@Entity
@Table(name = "authority")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value = { "new", "id" })
@Data
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Authority implements Serializable, Persistable<String> {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(max = 50)
    @Id
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Transient
    private boolean isPersisted;

    @PostLoad
    @PostPersist
    public void updateEntityState() {
        this.isPersisted = true;
    }

    @Override
    public String getId() {
        return this.name;
    }

    @Transient
    @Override
    public boolean isNew() {
        return !this.isPersisted;
    }


}
