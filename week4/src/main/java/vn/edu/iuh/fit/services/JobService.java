package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Job;
import vn.edu.iuh.fit.repositories.IJobRepository;
import vn.edu.iuh.fit.repositories.Impl.JobRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {

    private JobRepositoryImpl jobRepositoryImpl;

    @Autowired
    public JobService(JobRepositoryImpl jobRepositoryImpl) {
        this.jobRepositoryImpl = jobRepositoryImpl;
    }

    public boolean addJob(Job job) {
        return jobRepositoryImpl.addJob(job);
    }

    public boolean updateJob(Job job) {
        return jobRepositoryImpl.updateJob(job);
    }

    public boolean deleteJob(UUID jobId) {
        return jobRepositoryImpl.deleteJob(jobId);
    }

    public Optional<Job> getJobById(UUID id) {
        return jobRepositoryImpl.getJobById(id);
    }

    public List<Job> getAllJob() {
        return jobRepositoryImpl.getAllJob();
    }
}
