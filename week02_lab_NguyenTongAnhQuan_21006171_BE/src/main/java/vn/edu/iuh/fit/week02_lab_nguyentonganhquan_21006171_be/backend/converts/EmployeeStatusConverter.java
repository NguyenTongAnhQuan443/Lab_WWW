package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.converts;

import jakarta.persistence.AttributeConverter;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.enums.EmployeeStatus;

public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus employeeStatus) {
        if (employeeStatus == null) {
            return null;
        }
        return employeeStatus.getStatus();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == 1) {
            return EmployeeStatus.WORKING;
        } else if (dbData == 0) {
            return EmployeeStatus.UN_WORKING;
        } else if (dbData == -1) {
            return EmployeeStatus.QUITTED;
        }
        return null;
    }
}
