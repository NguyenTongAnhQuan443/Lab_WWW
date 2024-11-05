package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.enums.SkillType;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.Impl.SkillRepositoryImpl;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SkillRepositoryImplTest {

    @Autowired
    private SkillRepositoryImpl skillRepositoryImpl;

//    public class Skill {
//        private UUID id;
//        private String description;
//        private String name;
//        private SkillType type;
//
//        public Skill(UUID id) {
//            this.id = id;
//        }
//    }

    @Test
    void addSkill() {
        Skill skill = new Skill(UUID.randomUUID(), "Java", "Java", SkillType.BEGINNER);
        boolean result = skillRepositoryImpl.addSkill(skill);
        assertEquals(true, result);
    }
}
