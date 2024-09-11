package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.testing;

import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.impl.AccountRepositoryImpl;

public class TestAccountRepository {
    public static void main(String[] args) {
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();

        // Tạo một account mới để test phương thức save()
        Account newAccount = new Account();
        newAccount.setAccountId("test1");
        newAccount.setEmail("");
        newAccount.setFullName("");
        newAccount.setStatus((byte) 1);
        newAccount.setPassword("password123");

        // Lưu account vào database
//        accountRepository.save(newAccount);
        System.out.println(accountRepository.finById(Account.class, newAccount.getAccountId().toString()).toString());



    }
}
