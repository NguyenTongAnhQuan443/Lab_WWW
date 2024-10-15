package vn.edu.iuh.fit.models;

import lombok.*;
import vn.edu.iuh.fit.enums.SkillLevel;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class JobSkill {
    private Job job;
    private Skill skill;
    private String moreInfos;
    private SkillLevel skillLevel;


}
