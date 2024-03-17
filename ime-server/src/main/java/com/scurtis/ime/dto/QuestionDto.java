package com.scurtis.ime.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto implements Comparable<QuestionDto> {

    private Long id;
    private String question;
    private String answer;
    private String skill;
    private String category;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @Override
    public int compareTo(QuestionDto other) {
        if (this.id > other.id) {
            return 1;
        } else if (this.id < other.id) {
            return -1;
        }
        return 0;
    }

}
