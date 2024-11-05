package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.repositories.Impl.AddressRepositoryImpl;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AddressrepositoryImplTest {

    @Autowired
    private AddressRepositoryImpl addressRepositoryImpl;

    @Test
    void addAddress() {
        // Tạo đối tượng Address và lưu vào database
        Address address = new Address(UUID.randomUUID(), "HCM", (short) 1, "123", "Nguyen Van Linh", "700000");
        boolean result = addressRepositoryImpl.addAddress(address);

        // Kiểm tra kết quả
        assertEquals(true, result);
    }

    @Test
    void updateAddress() {
        Address address = addressRepositoryImpl.getAddressById(UUID.fromString("ec2a966c-870c-401d-9c1f-fcc96a6311ed")).orElse(null);
        Address addressUpdate = new Address(address.getId(), "HCM", (short) 1, "123", "Nguyen Van Linh", "700000");
        boolean result = addressRepositoryImpl.updateAddress(addressUpdate);
        assertEquals(true, result);
    }

    @Test
    void deleteAddress() {
        boolean result = addressRepositoryImpl.deleteAddress(UUID.fromString("ec2a966c-870c-401d-9c1f-fcc96a6311ed"));
        assertEquals(true, result);
    }

    @Test
    void getById(){
        Address address = addressRepositoryImpl.getAddressById(UUID.fromString("ec2a966c-870c-401d-9c1f-fcc96a6311ed")).orElse(null);
        assertEquals("HCM", address.getCity());
    }

}
