package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.converts.EmployeeStatusConverter;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.enums.EmployeeStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@XmlRootElement
public class Employee {
//    emp_id, full_name, dob, email, phone, address, status
    @Id
    @Column(name = "emp_id", columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emp_id;

    @Column(name = "full_name", columnDefinition = "VARCHAR(150)", nullable = false)
    private String full_name;

    @Column(name = "dob", columnDefinition = "DATETIME(6)" , nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dob;

    @Column(name = "email", columnDefinition = "VARCHAR(150)", nullable = false)
    private String email;

    @Column(name = "phone", columnDefinition = "VARCHAR(15)", nullable = false)
    private String phone;

    @Column(name = "address",columnDefinition = "VARCHAR(250)", nullable = false)
    private String address;

    @Convert(converter = EmployeeStatusConverter.class)
    private EmployeeStatus status;
}
