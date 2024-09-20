package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductStatus {
    ACTIVE(1), INACTIVE(0), DISCONTINUED(-1);

    private final int status;

    ProductStatus(int status) {
        this.status = status;
    }

    @JsonValue

    public int getStatus() {
        return status;
    }
}
