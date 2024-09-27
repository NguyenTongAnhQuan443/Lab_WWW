package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.enums;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class Employee {
//    employee (emp_id, full_name, dob, email, phone, address, status)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", length = 20, columnDefinition = "BIGINT")
    private Long emp_id;

    @Column(name = "full_name", length = 150, columnDefinition = "VARCHAR", nullable = false)
    private String full_name;

    @Column(name = "dob", length = 6, columnDefinition = "DATETIME", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dob;

    @Column(name = "email", length = 150, columnDefinition = "VARCHAR", unique = true)
    private String email;

    @Column(name = "phone", length = 15, columnDefinition = "VARCHAR", nullable = false, unique = true)
    private String phone;

    @Column(name = "address", length = 250, columnDefinition = "VARCHAR", nullable = false)
    private String address;

    @Column(name = "status", length = 11, columnDefinition = "INT", nullable = false)
    private int status;
}
