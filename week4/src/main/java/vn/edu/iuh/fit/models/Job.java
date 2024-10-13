package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private UUID id;
    private Company company;
    private String description;
    private String name;

    public Job(UUID id) {
        this.id = id;
    }
}