package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.CandidateSkill;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICandidateSkillRepository {
    boolean addCandidateSkill(CandidateSkill candidateSkill);

    boolean updateCandidateSkill(CandidateSkill candidateSkill);

    boolean deleteCandidateSkill(UUID candidateSkillId, UUID skillId);

    Optional<CandidateSkill> getCandidateSkillById(UUID candidateSkillId, UUID skillId);

    List<CandidateSkill> getAllCandidateSkill();


}