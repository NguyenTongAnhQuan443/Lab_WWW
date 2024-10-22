package vn.edu.iuh.fit.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.CandidateName;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class CandidateNameMapper implements RowMapper<CandidateName> {


    @Override
    public CandidateName mapRow(ResultSet rs, int rowNum) throws SQLException {
        CandidateName candidateName = new CandidateName();
        candidateName.setId(UUID.fromString(rs.getString("candidate_id")));
        candidateName.setLast_Name(rs.getString("last_name"));
        candidateName.setMiddle_Name(rs.getString("middle_name"));
        candidateName.setFirst_Name(rs.getString("first_name"));
        return candidateName;
    }
}
