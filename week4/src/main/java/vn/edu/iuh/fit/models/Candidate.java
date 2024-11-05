package vn.edu.iuh.fit.models;

import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
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

    //    GET FULL NAME
    public String getFullName() {
        return String.join(" ", first_Name, middle_Name, last_Name);
    }

    //    SET FULL NAME
    public void setFullName(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length >= 3) {
            this.first_Name = parts[0];
            this.last_Name = parts[parts.length - 1];
            this.middle_Name = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length - 1));
        } else if (parts.length == 2) {
            this.first_Name = parts[0];
            this.middle_Name = "";
            this.last_Name = parts[1];
        } else if (parts.length == 1) {
            this.first_Name = parts[0];
            this.middle_Name = "";
            this.last_Name = "";
        } else {
            this.first_Name = "";
            this.middle_Name = "";
            this.last_Name = "";
        }
    }
}
