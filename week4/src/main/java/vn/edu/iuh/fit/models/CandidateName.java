package vn.edu.iuh.fit.models;

import java.util.UUID;

public class CandidateName {
    private UUID id;
    private String last_Name;
    private String middle_Name;
    private String first_Name;

    public CandidateName() {
    }

    public CandidateName(UUID id, String last_Name, String middle_Name, String first_Name) {
        this.id = id;
        this.last_Name = last_Name;
        this.middle_Name = middle_Name;
        this.first_Name = first_Name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getMiddle_Name() {
        return middle_Name;
    }

    public void setMiddle_Name(String middle_Name) {
        this.middle_Name = middle_Name;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }
}
