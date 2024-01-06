package com.scurtis.ime.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "ime", name = "category")
public class Category implements Persistable<Long> {

    @Id
    private Long id;
    private String name;

    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }

}