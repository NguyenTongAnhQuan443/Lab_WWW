package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.CandidateName;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICandidateNameRepository {
    boolean addCandidateName(CandidateName candidateName);
    boolean updateCandidateName(CandidateName candidateName);
    boolean deleteCandidateName(UUID candidateNameId);
    Optional<CandidateName> getCandidateNameById(UUID candidateNameId);
    List<CandidateName> getAllCandidateName();
}
