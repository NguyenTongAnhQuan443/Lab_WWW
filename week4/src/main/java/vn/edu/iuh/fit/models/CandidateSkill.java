package vn.edu.iuh.fit.models;

import lombok.*;
import vn.edu.iuh.fit.enums.SkillLevel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CandidateSkill {
    private Candidate candidate;
    private Skill skill;
    private String moreInfos;
    private SkillLevel skillLevel;


}
