package com.scurtis.ime.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private Long id;
    private String question;
    private String answer;
    private String skill;
    private String category;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

}
