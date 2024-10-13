package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "job", schema = "week4")
public class Job {
    @Id
    @Column(name = "job_id", columnDefinition = "uuid not null")
    private Object id;

    @Column(name = "job_desc", nullable = false, length = 2000)
    private String jobDesc;

    @Column(name = "job_name", nullable = false)
    private String jobName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    private vn.edu.iuh.fit.Company company;

}