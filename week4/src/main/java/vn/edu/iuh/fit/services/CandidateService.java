package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.ICandidateRepository;
import vn.edu.iuh.fit.repositories.Impl.CandidateRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidateService {

    private CandidateRepositoryImpl candidateRepositoryImpl;

    @Autowired
    public CandidateService(CandidateRepositoryImpl candidateRepositoryImpl) {
        this.candidateRepositoryImpl = candidateRepositoryImpl;
    }

    public boolean addCandidate(Candidate candidate) {
        return candidateRepositoryImpl.addCandidate(candidate);
    }

    public boolean updateCandidate(Candidate candidate) {
        return candidateRepositoryImpl.updateCandidate(candidate);
    }

    public boolean deleteCandidate(UUID candidateId) {
        return candidateRepositoryImpl.deleteCandidate(candidateId);
    }

    public Optional<Candidate> getCandidateById(UUID id) {
        return candidateRepositoryImpl.getCandidateById(id);
    }

    public List<Candidate> getAllCandidate() {
        return candidateRepositoryImpl.getAllCandidate();
    }
}
