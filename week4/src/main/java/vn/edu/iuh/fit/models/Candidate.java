package vn.edu.iuh.fit.models;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Candidate {
    private UUID id;
    private String last_Name;
    private String middle_Name;
    private String first_Name;
    private String email;
    private String phone;
    private Address address;
    private LocalDate dob;

    public Candidate(UUID id) {
        this.id = id;
    }

    public void setAddress(Address address) {
    }

    public Candidate(UUID id, String last_Name, String middle_Name, String first_Name, String email, String phone, Address address, LocalDate dob) {
        this.id = id;
        this.last_Name = last_Name;
        this.middle_Name = middle_Name;
        this.first_Name = first_Name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
    }
}
