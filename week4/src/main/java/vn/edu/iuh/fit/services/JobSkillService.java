package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.JobSkill;
import vn.edu.iuh.fit.repositories.IJobSkillRepository;
import vn.edu.iuh.fit.repositories.Impl.JobSkillRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobSkillService {

    private JobSkillRepositoryImpl jobSkillRepositoryImpl;

    @Autowired
    public JobSkillService(JobSkillRepositoryImpl jobSkillRepositoryImpl) {
        this.jobSkillRepositoryImpl = jobSkillRepositoryImpl;
    }

    public boolean addJobSkill(JobSkill jobSkill) {
        return jobSkillRepositoryImpl.addJobSkill(jobSkill);
    }

    public boolean updateJobSkill(JobSkill jobSkill) {
        return jobSkillRepositoryImpl.updateJobSkill(jobSkill);
    }

    public boolean deleteJobSkill(UUID jobSkillId, UUID skillId) {
        return jobSkillRepositoryImpl.deleteJobSkill(jobSkillId, skillId);
    }

    public Optional<JobSkill> getJobSkillById(UUID jobId, UUID skillId) {
        return jobSkillRepositoryImpl.getJobSkillById(jobId, skillId);
    }

    public List<JobSkill> getAllJobSkill() {
        return jobSkillRepositoryImpl.getAllJobSkill();
    }
}
