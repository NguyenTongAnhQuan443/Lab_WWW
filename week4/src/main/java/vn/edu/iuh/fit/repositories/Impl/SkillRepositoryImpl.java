package vn.edu.iuh.fit.repositories.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.mappers.SkillMapper;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.ISkillRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SkillRepositoryImpl implements ISkillRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SkillRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean addSkill(Skill skill) {
        String sql = "INSERT INTO skill (skill_id, skill_description, skill_name, type) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, skill.getId(), skill.getDescription(), skill.getName(), skill.getType()) > 0;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        String sql = "UPDATE skill SET description = ?, name = ?, type = ? WHERE id = ?";
        return jdbcTemplate.update(skill.getDescription(), skill.getName(), skill.getType(), skill.getId()) > 0;
    }

    @Override
    public boolean deleteSkill(UUID id) {
        String sql = "DELETE FROM skill WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public Optional<Skill> getSkillById(UUID id) {
        String sql = "SELECT * FROM skill WHERE id = ?";
        Skill skill = jdbcTemplate.queryForObject(sql, new SkillMapper(), id);
        return skill != null ? Optional.of(skill) : Optional.empty();
    }

    @Override
    public List<Skill> getAllSkill() {
        String sql = "SELECT * FROM skill";
        return jdbcTemplate.query(sql, new SkillMapper());
    }
}
