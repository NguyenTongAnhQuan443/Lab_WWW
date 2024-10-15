package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Job;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IJobRepository {
    boolean addJob(Job job);

    boolean updateJob(Job job);

    boolean deleteJob(UUID job);

    Optional<Job> getJobById(UUID id);

    List<Job> getAllJob();
}