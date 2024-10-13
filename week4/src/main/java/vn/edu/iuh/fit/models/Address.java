package vn.edu.iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Address {
    private UUID id;
    private String city;
    private Short country;
    private String number;
    private String street;
    private String zipcode;

    public Address(UUID id) {
        this.id = id;
    }

}