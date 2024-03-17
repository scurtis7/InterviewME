package com.scurtis.ime.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "ime", name = "question")
public class Question implements Persistable<Long> {

    @Id
    private Long id;
    private String question;
    private String answer;
    private String skill;
    private String category;
    @ReadOnlyProperty
    private LocalDate createdDate;

    /**
     * This method is called by the R2DBC persistence framework to determine
     * if it's a new question or existing question.  If new then an insert
     * is done otherwise an update statement is executed.  This is the only
     * way the framework can know which statement to use and is hence required.
     *
     * @return true if this is a new question otherwise false
     */
    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }

}
