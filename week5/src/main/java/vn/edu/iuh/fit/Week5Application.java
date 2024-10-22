package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.util.Random;
import java.util.List;
@SpringBootApplication
public class Week5Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Week5Application.class, args);
    }


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
//        Random random = new Random();
//        for(int i = 0; i < 100; i++) {
//            Account account = new Account();
//            account.setId((long) i);
//            account.setOwnerName("Name #" + i);
//            account.setBalance(random.nextDouble() * 1000);
//
//            accountRepository.save(account);
//        }
//
//        accountRepository.findAll().forEach(System.out::println);

        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Account> content = accountRepository.findAll(pageRequest);
        List<Account> accountList = content.getContent();
        accountList.forEach(System.out::println);

    }
}
