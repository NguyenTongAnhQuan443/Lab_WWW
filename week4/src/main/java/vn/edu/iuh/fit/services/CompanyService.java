package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.repositories.ICompanyRepository;
import vn.edu.iuh.fit.repositories.Impl.CompanyRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {

    private CompanyRepositoryImpl companyRepositoryImpl;

    @Autowired
    public CompanyService(CompanyRepositoryImpl companyRepositoryImpl) {
        this.companyRepositoryImpl = companyRepositoryImpl;
    }

    public boolean addCompany(Company company) {
        return companyRepositoryImpl.addCompany(company);
    }

    public boolean updateCompany(Company company) {
        return companyRepositoryImpl.updateCompany(company);
    }

    public boolean deleteCompany(UUID company) {
        return companyRepositoryImpl.deleteCompany(company);
    }

    public Optional<Company> getCompanyById(UUID id) {
        return companyRepositoryImpl.getCompanyById(id);
    }

    public List<Company> getAllCompany() {
        return companyRepositoryImpl.getAllCompany();
    }
}
