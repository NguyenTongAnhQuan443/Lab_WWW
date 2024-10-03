package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.dtos.lessProperty;

import lombok.Value;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Order_Detail;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Order_Detail}
 */
@Value
public class Order_DetailDto implements Serializable {
    long orderOrder_id;
    LocalDateTime orderOrder_date;
    Long productProduct_id;
    String productName;
    double quantity;
    double price;
    String note;
}