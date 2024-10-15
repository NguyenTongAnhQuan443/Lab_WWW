package vn.edu.iuh.fit.models;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
