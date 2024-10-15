package vn.edu.iuh.fit.repositories.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.mappers.CompanyMapper;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.repositories.ICompanyRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CompanyRepositoryImpl implements ICompanyRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private CompanyMapper companyMapper;

    @Autowired
    public CompanyRepositoryImpl(DataSource dataSource, CompanyMapper companyMapper) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.companyMapper = companyMapper;
    }

    @Override
    public boolean addCompany(Company company) {
        String sql = "INSERT INTO company (comp_id, comp_name, email, phone, web_url, about, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, company.getId(), company.getCompName(), company.getEmail(), company.getPhone(),
                company.getWebUrl(), company.getAbout(), company.getAddress().getId()) > 0;
    }

    @Override
    public boolean updateCompany(Company company) {
        String sql = "UPDATE company SET comp_name = ?, email = ?, phone = ?, web_url = ?, about = ?, address = ? WHERE comp_id = ?";
        return jdbcTemplate.update(company.getCompName(), company.getEmail(), company.getPhone(), company.getWebUrl(),
                company.getAbout(), company.getAddress().getId(), company.getId()) > 0;
    }

    @Override
    public boolean deleteCompany(UUID id) {
        String sql = "DELETE FROM company WHERE comp_id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public Optional<Company> getCompanyById(UUID id) {
        String sql = "SELECT * FROM company WHERE comp_id = ?";
        Company company = jdbcTemplate.queryForObject(sql, companyMapper, id);
        return company != null ? Optional.of(company) : Optional.empty();
    }

    @Override
    public List<Company> getAllCompany() {
        String sql = "SELECT * FROM company";
        return jdbcTemplate.query(sql, companyMapper);
    }
}
