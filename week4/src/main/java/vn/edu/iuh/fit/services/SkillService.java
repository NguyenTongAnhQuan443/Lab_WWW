
package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.ISkillRepository;
import vn.edu.iuh.fit.repositories.Impl.SkillRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillService {

    private SkillRepositoryImpl skillRepositoryImpl;

    @Autowired
    public SkillService(SkillRepositoryImpl skillRepositoryImpl) {
        this.skillRepositoryImpl = skillRepositoryImpl;
    }

    public boolean addSkill(Skill skill) {
        return skillRepositoryImpl.addSkill(skill);
    }

    public boolean updateSkill(Skill skill) {
        return skillRepositoryImpl.updateSkill(skill);
    }

    public boolean deleteSkill(UUID skill) {
        return skillRepositoryImpl.deleteSkill(skill);
    }

    public Optional<Skill> getSkillById(UUID id) {
        return skillRepositoryImpl.getSkillById(id);
    }

    public List<Skill> getAllSkill() {
        return skillRepositoryImpl.getAllSkill();
    }
}
