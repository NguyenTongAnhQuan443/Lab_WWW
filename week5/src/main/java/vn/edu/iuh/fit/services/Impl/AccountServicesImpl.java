package vn.edu.iuh.fit.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.services.IAccountServices;

import java.util.List;

@Service
public class AccountServicesImpl implements IAccountServices{

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServicesImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> paginate(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return accountRepository.findAll(pageRequest).getContent();
    }

    @Override
    public List<Account> findByBalanceGreaterThan(double amount, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return accountRepository.findByBalanceGreaterThan(amount, pageRequest);
    }
}
