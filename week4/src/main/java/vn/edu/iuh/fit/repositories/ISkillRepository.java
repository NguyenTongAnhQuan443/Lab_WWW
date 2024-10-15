package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Skill;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ISkillRepository {
    boolean addSkill(Skill skill);

    boolean updateSkill(Skill skill);

    boolean deleteSkill(UUID skill);

    Optional<Skill> getSkillById(UUID id);

    List<Skill> getAllSkill();
}
