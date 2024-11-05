package vn.edu.iuh.fit.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.Impl.AddressRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class CandidateMapper implements RowMapper<Candidate> {

    private AddressRepositoryImpl addressRepositoryImpl;

    @Autowired
    public CandidateMapper(AddressRepositoryImpl addressRepositoryImpl) {
        this.addressRepositoryImpl = addressRepositoryImpl;
    }

    @Override
    public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(UUID.fromString(rs.getString("id")));
        candidate.setLast_Name(rs.getString("last_name"));
        candidate.setMiddle_Name(rs.getString("middle_name"));
        candidate.setFirst_Name(rs.getString("first_name"));
        candidate.setEmail(rs.getString("email"));
        candidate.setPhone(rs.getString("phone"));
        candidate.setDob(rs.getDate("dob").toLocalDate());
        candidate.setAddress(addressRepositoryImpl.getAddressById(UUID.fromString(rs.getString("address"))).orElse(null));
        return candidate;
    }
}
