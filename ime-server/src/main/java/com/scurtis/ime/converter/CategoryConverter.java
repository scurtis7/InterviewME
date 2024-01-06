package com.scurtis.ime.converter;

import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryConverter {

    public CategoryDto toDto(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getCreatedDate());
    }

}
