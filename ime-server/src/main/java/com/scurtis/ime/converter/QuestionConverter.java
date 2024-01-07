package com.scurtis.ime.converter;

import com.scurtis.ime.dto.QuestionDto;
import com.scurtis.ime.entity.Question;
import org.springframework.stereotype.Service;

@Service
public class QuestionConverter {

    public QuestionDto toDto(Question entity) {
        return new QuestionDto(entity.getId(), entity.getQuestion(), entity.getAnswer(),
            entity.getSkill(), entity.getCategory(), entity.getCreatedDate());
    }

    public Question toEntity(QuestionDto dto) {
        return Question.builder()
            .id(dto.getId())
            .question(dto.getQuestion())
            .answer(dto.getAnswer())
            .skill(dto.getSkill())
            .category(dto.getCategory())
            .build();
    }

}
