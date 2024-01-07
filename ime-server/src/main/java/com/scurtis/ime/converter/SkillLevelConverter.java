package com.scurtis.ime.converter;

import com.scurtis.ime.dto.SkillLevelDto;
import com.scurtis.ime.entity.SkillLevel;
import org.springframework.stereotype.Service;

@Service
public class SkillLevelConverter {

    public SkillLevelDto toDto(SkillLevel entity) {
        return new SkillLevelDto(entity.getId(), entity.getName(), entity.getCreatedDate());
    }

}
