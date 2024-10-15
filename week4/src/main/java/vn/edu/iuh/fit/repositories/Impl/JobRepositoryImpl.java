package vn.edu.iuh.fit.repositories.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.mappers.JobMapper;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.models.Job;
import vn.edu.iuh.fit.repositories.IJobRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JobRepositoryImpl implements IJobRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private JobMapper jobMapper;

    @Autowired
    public JobRepositoryImpl(DataSource dataSource, JobMapper jobMapper) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jobMapper = jobMapper;
    }

    @Override
    public boolean addJob(Job job) {
        String sql = "INSERT INTO job (job_id, company, job_desc, job_name) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, job.getId(), job.getCompany().getId(), job.getDescription(), job.getName()) > 0;
    }

    @Override
    public boolean updateJob(Job job) {
        String sql = "UPDATE job SET company = ?, job_desc = ?, job_name = ? WHERE job_id = ?";
        return jdbcTemplate.update(sql, job.getCompany().getId(), job.getDescription(), job.getName(), job.getId()) > 0;
    }

    @Override
    public boolean deleteJob(UUID jobId) {
        String sql = "DELETE FROM job WHERE job_id = ?";
        return jdbcTemplate.update(sql, jobId) > 0;
    }

    @Override
    public Optional<Job> getJobById(UUID id) {
        String sql = "SELECT * FROM job WHERE job_id = ?";
        Job job = jdbcTemplate.queryForObject(sql, jobMapper, id);
        return job != null ? Optional.of(job) : Optional.empty();
    }

    @Override
    public List<Job> getAllJob() {
        String sql = "SELECT * FROM job";
        return jdbcTemplate.query(sql, jobMapper);
    }
}
