package vn.edu.iuh.fit.repositories.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.CandidateName;
import vn.edu.iuh.fit.repositories.ICandidateNameRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CandidateNameRepositoryImpl implements ICandidateNameRepository {


    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CandidateNameRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean addCandidateName(CandidateName candidateName) {
//        private UUID id;
//        private String last_Name;
//        private String middle_Name;
//        private String first_Name;
        String sql = "insert into candidatename (candidate_id, last_name, middle_name, first_name) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, candidateName.getId(), candidateName.getLast_Name(), candidateName.getMiddle_Name(), candidateName.getFirst_Name()) > 0;
    }

    @Override
    public boolean updateCandidateName(CandidateName candidateName) {
        String sql = "update candidatename set last_name = ?, middle_name = ?, first_name = ? where candidate_id = ?";
        return jdbcTemplate.update(sql, candidateName.getLast_Name(), candidateName.getMiddle_Name(), candidateName.getFirst_Name(), candidateName.getId()) > 0;
    }

    @Override
    public boolean deleteCandidateName(UUID candidateNameId) {
        String sql = "delete from candidatename where candidate_id = ?";
        return jdbcTemplate.update(sql, candidateNameId) > 0;
    }

    @Override
    public Optional<CandidateName> getCandidateNameById(UUID candidateNameId) {
        String sql = "select * from candidatename where candidate_id = ?";
        CandidateName candidateName = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(CandidateName.class), candidateNameId);
        return candidateName != null ? Optional.of(candidateName) : Optional.empty();
    }

    @Override
    public List<CandidateName> getAllCandidateName() {
        String sql = "select * from candidate_name";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CandidateName.class));
    }
}
