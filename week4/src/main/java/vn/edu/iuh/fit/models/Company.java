package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {
    private UUID id;
    private String about;
    private Address address;
    private String compName;
    private String email;
    private String phone;
    private String webUrl;

    public Company(UUID id) {
        this.id = id;
    }
}