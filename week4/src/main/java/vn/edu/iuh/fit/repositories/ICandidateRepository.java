package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Candidate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICandidateRepository {
    boolean addCandidate(Candidate candidate);

    boolean updateCandidate(Candidate candidate);

    boolean deleteCandidate(UUID candidateId);

    Optional<Candidate> getCandidateById(UUID id);

    List<Candidate> getAllCandidate();
}
