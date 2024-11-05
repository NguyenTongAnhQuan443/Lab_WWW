package vn.edu.iuh.fit.repositories;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.Impl.AddressRepositoryImpl;
import vn.edu.iuh.fit.repositories.Impl.CandidateRepositoryImpl;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CandidateRepositoryImplTest {

    @Autowired
    private CandidateRepositoryImpl candidateRepositoryImpl;

    @Autowired
    private AddressRepositoryImpl addressRepositoryImpl;

    @Test
    void addCandidate() {
        // Tạo đối tượng Address và lưu vào database
        Address address = new Address(UUID.randomUUID(), "HCM", (short) 1, "123", "Nguyen Van Linh", "700000");
        addressRepositoryImpl.addAddress(address);

        // Tạo Candidate và lưu vào database trước
        UUID candidateId = UUID.randomUUID();
        Candidate candidate = new Candidate(candidateId, "Nguyen", "Van", "A", "nguyenvana@gmail.com", "0123456789", address, LocalDate.of(1999, 1, 1));
        boolean result = candidateRepositoryImpl.addCandidate(candidate);

        // Kiểm tra kết quả
        assertEquals(true, result);
    }

    @Test
    void updateCandidate() {
        Address address = new Address(UUID.randomUUID(), "HCM", (short) 1, "123", "Nguyen Van Linh", "700000");
        addressRepositoryImpl.addAddress(address);

        Candidate candidate = candidateRepositoryImpl.getCandidateById(UUID.fromString("ec2a966c-870c-401d-9c1f-fcc96a6311ed")).orElse(null);
        Candidate candidateUpdate = new Candidate(candidate.getId(), "Nguyen", "Van", "B", "nguyenvanb@gmail.com", "0123456789", address, LocalDate.of(1999, 1, 1));
        boolean result = candidateRepositoryImpl.updateCandidate(candidateUpdate);
        assertEquals(true, result);
    }

    void deleteCandidate() {
        boolean result = candidateRepositoryImpl.deleteCandidate(UUID.fromString("ec2a966c-870c-401d-9c1f-fcc96a6311ed"));
        assertEquals(true, result);
    }

    @Test
    void getById(){
        Candidate candidate = candidateRepositoryImpl.getCandidateById(UUID.fromString("ec2a966c-870c-401d-9c1f-fcc96a6311ed")).orElse(null);
        System.out.println(candidate);
        assertNotNull(candidate);
    }



}
