package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.services;

import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.Impl.AccountRepository;

import java.util.List;

public class AccountServices {
    private AccountRepository accountRepository;

    public AccountServices() {
        accountRepository = new AccountRepository();
    }

    public void addAccount(Account account) {
        accountRepository.add(account);
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


//    method is login
//    public Optional<Account> isLogin(String username, String password) {
//        if(username == null || password == null || username.isEmpty() || password.isEmpty())
//            return Optional.empty();
//        return accountRepository.isLogin(username, password);
//    }

    public Account isLogin(String userName, String password) {
        return accountRepository.isLogin(userName, password);
    }

    public Object findAll() {
        return accountRepository.findAll(Account.class);
    }
}
