package vn.edu.iuh.fit.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.services.Impl.AccountServicesImpl;

@RestController
@RequestMapping("/accounts")
public class AccountResource {
    private final AccountServicesImpl accountServicesImpl;

    @Autowired
    public AccountResource(AccountServicesImpl accountServicesImpl) {
        this.accountServicesImpl = accountServicesImpl;
    }

    @GetMapping("/{page}/{size}")
    public String getAccounts(@PathVariable int page, @PathVariable int size) {
        return accountServicesImpl.paginate(page, size).toString();
    }

    @GetMapping("/balance/{amount}/{page}/{size}")
    public String getAccountsByBalanceGreaterThan(@PathVariable double amount, @PathVariable int page, @PathVariable int size) {
        return accountServicesImpl.findByBalanceGreaterThan(amount, page, size).toString();
    }
}
