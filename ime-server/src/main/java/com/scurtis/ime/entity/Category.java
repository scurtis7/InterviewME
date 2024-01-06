package com.scurtis.ime.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private LocalDate createdDate;

    /**
     * This method is called by the R2DBC persistence framework to determine
     * if it's a new category or existing category.  If new then an insert
     * is done otherwise an update statement is executed.  This is the only
     * way the framework can know which statement to use and is hence required.
     *
     * @return true if this is a new category otherwise false
     */
    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }

}
