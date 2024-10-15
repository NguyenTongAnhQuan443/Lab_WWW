package vn.edu.iuh.fit.repositories.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.mappers.CandidateMapper;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.ICandidateRepository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.UUID;

@Repository
public class CandidateRepositoryImpl implements ICandidateRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    public CandidateRepositoryImpl(DataSource dataSource, CandidateMapper candidateMapper) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.candidateMapper = candidateMapper;
    }

    @Override
    public boolean addCandidate(Candidate candidate) {
        String sql = "INSERT INTO candidate (id, last_name, middle_name, first_name, email, phone, address, dob) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                candidate.getId(), candidate.getLast_Name(), candidate.getMiddle_Name(), candidate.getFirst_Name(),
                candidate.getEmail(), candidate.getPhone(), candidate.getAddress().getId(), candidate.getDob()) > 0;
    }

    @Override
    public boolean updateCandidate(Candidate candidate) {
        String sql = "UPDATE candidate SET last_name = ?, middle_name = ?, first_name = ?, email = ?, phone = ?, address = ?, dob = ? WHERE id = ?";
        return jdbcTemplate.update(sql, candidate.getLast_Name(), candidate.getMiddle_Name(),
                candidate.getFirst_Name(), candidate.getEmail(), candidate.getPhone(), candidate.getAddress().getId(),
                candidate.getDob(), candidate.getId()) > 0;
    }

    @Override
    public boolean deleteCandidate(UUID candidateId) {
        String sql = "DELETE FROM candidate WHERE id = ?";
        return jdbcTemplate.update(sql, candidateId) > 0;
    }

    @Override
    public Optional<Candidate> getCandidateById(UUID id) {
        String sql = "SELECT * FROM candidate WHERE id = ?";
        Candidate candidate = jdbcTemplate.queryForObject(sql, candidateMapper, id);
        return candidate != null ? Optional.of(candidate) : Optional.empty();
    }

    @Override
    public List<Candidate> getAllCandidate() {
        String sql = "SELECT * FROM candidate";
        return jdbcTemplate.query(sql, candidateMapper);
    }
}
