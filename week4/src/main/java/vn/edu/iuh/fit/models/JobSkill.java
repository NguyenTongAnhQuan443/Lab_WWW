package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.Enums.SkillLevel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobSkill {
    private Job job;
    private Skill skill;
    private String moreInfos;
    private SkillLevel skillLevel;
}