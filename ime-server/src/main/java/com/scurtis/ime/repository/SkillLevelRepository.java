package com.scurtis.ime.repository;

import com.scurtis.ime.entity.SkillLevel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillLevelRepository extends ReactiveCrudRepository<SkillLevel, Long> {
}
