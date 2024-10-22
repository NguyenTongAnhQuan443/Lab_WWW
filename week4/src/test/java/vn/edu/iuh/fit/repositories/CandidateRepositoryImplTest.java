package vn.edu.iuh.fit.repositories;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.CandidateName;
import vn.edu.iuh.fit.repositories.Impl.AddressRepositoryImpl;
import vn.edu.iuh.fit.repositories.Impl.CandidateNameRepositoryImpl;
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

    @Autowired
    private CandidateNameRepositoryImpl candidateNameRepositoryImpl;

    @Test
    void addCandidate() {
        // Tạo đối tượng Address và lưu vào database
        Address address = new Address(UUID.randomUUID(), "HCM", (short) 1, "123", "Nguyen Van Linh", "700000");
        addressRepositoryImpl.addAddress(address);

        // Tạo Candidate và lưu vào database trước
        UUID candidateId = UUID.randomUUID();
        Candidate candidate = new Candidate(candidateId, "Nguyen", "Van", "A", "nguyenvana@gmail.com", "0123456789", address, LocalDate.of(1999, 1, 1));
        boolean result = candidateRepositoryImpl.addCandidate(candidate);

        // Sau khi đã có Candidate, tạo CandidateName và lưu vào database
        CandidateName candidateName = new CandidateName(candidateId, "Nguyen", "Van", "A");
        candidateNameRepositoryImpl.addCandidateName(candidateName);

        // Kiểm tra kết quả
        assertEquals(true, result);
    }

//    @Test
//    void getById(){
//        Candidate candidate = candidateRepositoryImpl.getCandidateById(UUID.fromString("59aec30a-4bd1-428b-9353-6cc64eafc067")).orElse(null);
//        System.out.println(candidate);
//
//        System.
//        assertNotNull(candidate);
//    }

}
