package vn.edu.iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class JobSkillId implements Serializable {
    private static final long serialVersionUID = -4967273825233907277L;
    @Column(name = "job_id", columnDefinition = "uuid not null")
    private Object jobId;

    @Column(name = "skill_id", columnDefinition = "uuid not null")
    private Object skillId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JobSkillId entity = (JobSkillId) o;
        return Objects.equals(this.jobId, entity.jobId) &&
                Objects.equals(this.skillId, entity.skillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, skillId);
    }

}