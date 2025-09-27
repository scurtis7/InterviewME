package com.scurtis.ime.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillLevelDto {

    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

}
