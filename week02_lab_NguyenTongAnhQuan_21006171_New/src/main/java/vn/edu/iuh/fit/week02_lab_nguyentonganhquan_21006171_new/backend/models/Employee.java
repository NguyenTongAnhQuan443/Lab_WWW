package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.enums.EmployeeStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.getEmpByPageNum", query="SELECT e from Employee e where e.status <> :status"),
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e")
})
public class Employee {
//    employee (emp_id, full_name, dob, email, phone, address, status)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", columnDefinition = "BIGINT(20)")
    private long emp_id;

    @Column(name = "full_name", columnDefinition = "VARCHAR(150)", nullable = false)
    private String full_name;

    @Column(name = "dob", columnDefinition = "DATETIME(6)", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dob;

    @Column(name = "email", columnDefinition = "VARCHAR(150)", unique = true)
    private String email;

    @Column(name = "phone", columnDefinition = "VARCHAR(15)", nullable = false, unique = true)
    private String phone;

    @Column(name = "address", columnDefinition = "VARCHAR(250)", nullable = false)
    private String address;

    @Column(name = "status", columnDefinition = "INT(11)", nullable = false)
    private EmployeeStatus status;

    @OneToMany(mappedBy = "emp_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> lstOrder;

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public List<Order> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
    }

    public Employee(long emp_id, String full_name, LocalDateTime dob, String email, String phone, String address, EmployeeStatus status, List<Order> lstOrder) {
        this.emp_id = emp_id;
        this.full_name = full_name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.lstOrder = lstOrder;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", full_name='" + full_name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", lstOrder=" + lstOrder +
                '}';
    }
}
