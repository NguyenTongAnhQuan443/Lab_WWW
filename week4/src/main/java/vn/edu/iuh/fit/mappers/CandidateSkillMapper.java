package vn.edu.iuh.fit.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.repositories.Impl.CandidateRepositoryImpl;
import vn.edu.iuh.fit.repositories.Impl.SkillRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class CandidateSkillMapper implements RowMapper<CandidateSkill> {

    private CandidateRepositoryImpl candidateRepositoryImpl;
    private SkillRepositoryImpl skillRepositoryImpl;

    @Autowired
    public CandidateSkillMapper(CandidateRepositoryImpl candidateRepositoryImpl, SkillRepositoryImpl skillRepositoryImpl) {
        this.candidateRepositoryImpl = candidateRepositoryImpl;
        this.skillRepositoryImpl = skillRepositoryImpl;
    }

    @Override
    public CandidateSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
        CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setCandidate(candidateRepositoryImpl.getCandidateById(UUID.fromString(rs.getString("can_id"))).orElse(null));
        candidateSkill.setSkill(skillRepositoryImpl.getSkillById(UUID.fromString(rs.getString("skill_id"))).orElse(null));
        candidateSkill.setMoreInfos(rs.getString("more_infos"));
        candidateSkill.setSkillLevel(SkillLevel.getSkillLevel(rs.getInt("skill_level")));

        return candidateSkill;
    }
}
