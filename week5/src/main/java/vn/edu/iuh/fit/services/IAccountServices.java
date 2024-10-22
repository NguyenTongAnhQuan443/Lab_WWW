package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Account;

import java.util.List;

public interface IAccountServices {
    List<Account> paginate(int page, int size);

    List<Account> findByBalanceGreaterThan(double amount, int page, int size);
}
