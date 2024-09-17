package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.services;

import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.Impl.AccountRepository;

import java.util.List;

public class AccountServices {
    private AccountRepository accountRepository;

    public AccountServices() {
        accountRepository = new AccountRepository();
    }

    public boolean addAccount(Account account) {
        return accountRepository.add(account);
    }

    public boolean deleteAccount(String id) {
        return accountRepository.deleteByID(Account.class, id);
    }

    public boolean updateAccount(Account account) {
        return accountRepository.update(account);
    }

    public Account findAccount(String id) {
        return accountRepository.findById(Account.class, id);
    }

    public List<Account> findAllAccount() {
        return accountRepository.findAll(Account.class);
    }

    public Account isLogin(String userName, String password) {
        return accountRepository.isLogin(userName, password);
    }

    public Object findAll() {
        return accountRepository.findAll(Account.class);
    }
}
