package com.scurtis.ime.converter;

import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryConverter {

    public CategoryDto toDto(Category entity) {
        return new CategoryDto(entity.getId(), entity.getName(), entity.getCreatedDate());
    }

    public Category toEntity(CategoryDto dto) {
        return Category.builder()
            .id(dto.getId())
            .name(dto.getName().toUpperCase())
            .build();
    }

}
