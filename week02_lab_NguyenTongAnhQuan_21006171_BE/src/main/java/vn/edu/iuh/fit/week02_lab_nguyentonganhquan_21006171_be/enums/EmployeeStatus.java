package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.enums;
import com.fasterxml.jackson.annotation.JsonValue;
public enum EmployeeStatus {
    WORKING(1), UN_WORKING(0), QUITTED(-1);
    private final int status;
    private EmployeeStatus(int status){
        this.status = status;
    }
    @JsonValue
    public int getStatus(){
        return status;
    }
}
