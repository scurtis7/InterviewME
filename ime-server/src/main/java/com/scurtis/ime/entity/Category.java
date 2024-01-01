package com.scurtis.ime.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "category")
public class Category {

    @Id
    private int id;
    private String name;

}
