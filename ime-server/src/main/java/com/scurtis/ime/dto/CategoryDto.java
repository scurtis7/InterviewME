package com.scurtis.ime.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Comparable<CategoryDto> {

    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @Override
    public int compareTo(CategoryDto category) {
        return name.compareTo(category.name);
    }

}
