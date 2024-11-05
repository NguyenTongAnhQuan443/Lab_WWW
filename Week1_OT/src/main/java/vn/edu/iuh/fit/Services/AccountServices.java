package vn.edu.iuh.fit.Services;

import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountServices {
    private AccountRepository accountRepository;

//    Constructor khong tham so
    public AccountServices() {
        accountRepository = new AccountRepository();
    }

    public boolean addAccount(Account account){
        return accountRepository.add(account);
    }

    public boolean deleteAccount(String id){
        return accountRepository.deleteByID(id);
    }

    public boolean updateAccount(Account account){
        return accountRepository.update(account);
    }

    public Account findByID(String id){
        return accountRepository.findByID(id);
    }

    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    public Account checkLogin(String id, String pass){
        return accountRepository.checkLogin(id, pass);
    }
}
