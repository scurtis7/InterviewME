package com.scurtis.ime;

import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.dto.CriteriaDto;
import com.scurtis.ime.dto.QuestionDto;
import com.scurtis.ime.dto.SkillLevelDto;
import com.scurtis.ime.entity.Category;
import com.scurtis.ime.entity.Question;
import com.scurtis.ime.entity.SkillLevel;
import java.time.LocalDate;
import java.util.List;

public class TestUtils {

    public static Long CATEGORY_ID = 1L;
    public static String CATEGORY_NAME = "'categoryName'";
    public static Long SKILL_LEVEL_ID = 2L;
    public static String SKILL_LEVEL_NAME = "'skillLevelName'";
    public static Long QUESTION_ID = 3L;
    public static String QUESTION = "question";
    public static String ANSWER = "answer";

    private TestUtils() {
        // Prevent instantiation
    }

    public static Category getCategoryEntity() {
        return new Category(CATEGORY_ID, CATEGORY_NAME, null);
    }

    public static CategoryDto getCategoryDto() {
        return new CategoryDto(CATEGORY_ID, CATEGORY_NAME, LocalDate.now());
    }

    public static SkillLevel getSkillLevelEntity() {
        return new SkillLevel(SKILL_LEVEL_ID, SKILL_LEVEL_NAME, LocalDate.now());
    }

    public static SkillLevelDto getSkillLevelDto() {
        return new SkillLevelDto(SKILL_LEVEL_ID, SKILL_LEVEL_NAME, LocalDate.now());
    }

    public static QuestionDto getQuestionDto() {
        return new QuestionDto(QUESTION_ID, QUESTION, ANSWER, SKILL_LEVEL_NAME, CATEGORY_NAME, LocalDate.now());
    }

    public static Question getQuestionEntity() {
        return new Question(QUESTION_ID, QUESTION, ANSWER, SKILL_LEVEL_NAME, CATEGORY_NAME, LocalDate.now());
    }

    public static CriteriaDto getCriteriaDto() {
        CriteriaDto dto = new CriteriaDto();
        dto.setCategories(List.of(CATEGORY_NAME));
        dto.setSkills(List.of(SKILL_LEVEL_NAME));
        return dto;
    }

}
