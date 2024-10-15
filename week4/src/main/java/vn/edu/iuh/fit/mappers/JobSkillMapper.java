package vn.edu.iuh.fit.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.models.JobSkill;
import vn.edu.iuh.fit.repositories.Impl.JobRepositoryImpl;
import vn.edu.iuh.fit.repositories.Impl.SkillRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class JobSkillMapper implements RowMapper<JobSkill> {

    private SkillRepositoryImpl skillRepositoryImpl;
    private JobRepositoryImpl jobRepositoryImpl;

    @Autowired
    public JobSkillMapper(SkillRepositoryImpl skillRepositoryImpl, JobRepositoryImpl jobRepositoryImpl) {
        this.skillRepositoryImpl = skillRepositoryImpl;
        this.jobRepositoryImpl = jobRepositoryImpl;
    }

    @Override
    public JobSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
        JobSkill jobSkill = new JobSkill();
        jobSkill.setSkill(skillRepositoryImpl.getSkillById(UUID.fromString(rs.getString("skill_id"))).orElse(null));
        jobSkill.setJob(jobRepositoryImpl.getJobById(UUID.fromString(rs.getString("job_id"))).orElse(null));
        jobSkill.setMoreInfos(rs.getString("more_infos"));
        jobSkill.setSkillLevel(SkillLevel.getSkillLevel(rs.getInt("skill_level")));

        return jobSkill;
    }
}
