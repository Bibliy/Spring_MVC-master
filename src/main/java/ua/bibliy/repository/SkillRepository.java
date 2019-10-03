package ua.bibliy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bibliy.Model.Skill;

public interface SkillRepository  extends JpaRepository<Skill,Integer> {
}
