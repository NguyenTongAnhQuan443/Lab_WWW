package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.converts;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.enums.ProductStatus;

@Converter(autoApply = true)
public class ProductStatusConvert implements AttributeConverter<ProductStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductStatus productStatus) {
        if (productStatus == null) {
            return null;
        }
        return productStatus.getStatus();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer integer) {
        if (integer == 1) {
            return ProductStatus.ACTIVE;
        } else if (integer == 0) {
            return ProductStatus.INACTIVE;
        } else if (integer == -1) {
            return ProductStatus.DISCONTINUED;
        }
        return null;
    }
}
