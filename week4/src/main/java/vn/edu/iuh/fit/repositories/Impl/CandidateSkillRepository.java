package vn.edu.iuh.fit.repositories.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.mappers.CandidateSkillMapper;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.ICandidateRepository;
import vn.edu.iuh.fit.repositories.ICandidateSkillRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CandidateSkillRepository implements ICandidateSkillRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private CandidateSkillMapper candidateSkillMapper;

    @Autowired
    public CandidateSkillRepository(DataSource dataSource, CandidateSkillMapper candidateSkillMapper) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.candidateSkillMapper = candidateSkillMapper;
    }

    @Override
    public boolean addCandidateSkill(CandidateSkill candidateSkill) {
        String sql = "INSERT INTO candidate_skill (can_id, skill_id, more_infos, skill_level) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, candidateSkill.getCandidate().getId(), candidateSkill.getSkill().getId(),
                candidateSkill.getMoreInfos(), candidateSkill.getSkillLevel()) > 0;
    }

    @Override
    public boolean updateCandidateSkill(CandidateSkill candidateSkill) {
        String sql = "UPDATE candidate_skill SET more_infos = ?, skill_level = ? WHERE can_id = ? AND skill_id = ?";
        return jdbcTemplate.update(sql, candidateSkill.getMoreInfos(), candidateSkill.getSkillLevel(),
                candidateSkill.getCandidate().getId(), candidateSkill.getSkill().getId()) > 0;
    }

    @Override
    public boolean deleteCandidateSkill(UUID candidateSkillId, UUID skillId) {
        String sql = "DELETE FROM candidate_skill WHERE can_id = ? AND skill_id = ?";
        return jdbcTemplate.update(sql, candidateSkillMapper, candidateSkillId, skillId) > 0;
    }

    @Override
    public Optional<CandidateSkill> getCandidateSkillById(UUID candidateSkillId, UUID skillId) {
        String sql = "SELECT * FROM candidate_skill WHERE can_id = ? AND skill_id = ?";
        CandidateSkill candidateSkill = jdbcTemplate.queryForObject(sql, candidateSkillMapper, candidateSkillId, skillId);
        return candidateSkill != null ? Optional.of(candidateSkill) : Optional.empty();
    }

    @Override
    public List<CandidateSkill> getAllCandidateSkill() {
        String sql = "SELECT * FROM candidate_skill";
        return jdbcTemplate.query(sql, candidateSkillMapper);
    }
}
