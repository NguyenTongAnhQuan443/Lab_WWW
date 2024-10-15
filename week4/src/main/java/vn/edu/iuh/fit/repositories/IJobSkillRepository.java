package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.JobSkill;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IJobSkillRepository {
    boolean addJobSkill(JobSkill jobSkill);

    boolean updateJobSkill(JobSkill jobSkill);

    boolean deleteJobSkill(UUID jobSkillId, UUID skillId);

    Optional<JobSkill> getJobSkillById(UUID id, UUID skillId);

    List<JobSkill> getAllJobSkill();
}
