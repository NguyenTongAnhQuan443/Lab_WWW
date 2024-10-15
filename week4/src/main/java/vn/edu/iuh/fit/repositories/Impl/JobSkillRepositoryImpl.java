package vn.edu.iuh.fit.repositories.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.mappers.JobSkillMapper;
import vn.edu.iuh.fit.models.Job;
import vn.edu.iuh.fit.models.JobSkill;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.IJobSkillRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JobSkillRepositoryImpl implements IJobSkillRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private JobSkillMapper jobSkillMapper;

    @Autowired
    public JobSkillRepositoryImpl(DataSource dataSource, JobSkillMapper jobSkillMapper) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jobSkillMapper = jobSkillMapper;
    }

    @Override
    public boolean addJobSkill(JobSkill jobSkill) {
        String sql = "INSERT INTO job_skill (job_id, skill_id, more_infos, skill_level) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, jobSkill.getJob().getId(), jobSkill.getSkill().getId(),
                jobSkill.getMoreInfos(), jobSkill.getSkillLevel().getLevelNumber()) > 0;
    }

    @Override
    public boolean updateJobSkill(JobSkill jobSkill) {
        String sql = "UPDATE job_skill SET more_infos = ?, skill_level = ? WHERE job_id = ? AND skill_id = ?";
        return jdbcTemplate.update(sql, jobSkill.getMoreInfos(), jobSkill.getSkillLevel().getLevelNumber(),
                jobSkill.getJob().getId(), jobSkill.getSkill().getId()) > 0;
    }

    @Override
    public boolean deleteJobSkill(UUID jobSkillId, UUID skillId) {
        String sql = "DELETE FROM job_skill WHERE job_id = ? AND skill_id = ?";
        return jdbcTemplate.update(sql, jobSkillId, skillId) > 0;
    }

    @Override
    public Optional<JobSkill> getJobSkillById(UUID jobId, UUID skillId) {
        String sql = "SELECT * FROM job_skill WHERE job_id = ? AND skill_id = ?";
        JobSkill jobSkill = jdbcTemplate.queryForObject(sql, jobSkillMapper, jobId, skillId);
        return jobSkill != null ? Optional.of(jobSkill) : Optional.empty();
    }

    @Override
    public List<JobSkill> getAllJobSkill() {
        String sql = "SELECT * FROM job_skill";
        return jdbcTemplate.query(sql, jobSkillMapper);
    }
}
