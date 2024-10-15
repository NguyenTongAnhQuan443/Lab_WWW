package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICompanyRepository {
    boolean addCompany(Company company);

    boolean updateCompany(Company company);

    boolean deleteCompany(UUID company);

    Optional<Company> getCompanyById(UUID id);

    List<Company> getAllCompany();
}
