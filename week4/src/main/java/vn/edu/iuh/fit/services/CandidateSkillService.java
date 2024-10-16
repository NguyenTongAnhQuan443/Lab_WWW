package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.repositories.Impl.CandidateSkillRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidateSkillService {

    private CandidateSkillRepositoryImpl candidateSkillRepositoryImpl;

    @Autowired
    public CandidateSkillService(CandidateSkillRepositoryImpl candidateSkillRepositoryImpl) {
        this.candidateSkillRepositoryImpl = candidateSkillRepositoryImpl;
    }

    public boolean addCandidateSkill(CandidateSkill candidateSkill) {
        return candidateSkillRepositoryImpl.addCandidateSkill(candidateSkill);
    }

    public boolean updateCandidateSkill(CandidateSkill candidateSkill) {
        return candidateSkillRepositoryImpl.updateCandidateSkill(candidateSkill);
    }

    public boolean deleteCandidateSkill(UUID candidateSkillId, UUID skillId) {
        return candidateSkillRepositoryImpl.deleteCandidateSkill(candidateSkillId, skillId);
    }

    public Optional<CandidateSkill> getCandidateSkillById(UUID candidateSkillId, UUID skillId) {
        return candidateSkillRepositoryImpl.getCandidateSkillById(candidateSkillId, skillId);
    }

    public List<CandidateSkill> getAllCandidateSkill() {
        return candidateSkillRepositoryImpl.getAllCandidateSkill();
    }
}
