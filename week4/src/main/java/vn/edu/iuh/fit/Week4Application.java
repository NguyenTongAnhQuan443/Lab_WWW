package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.iuh.fit.repositories.Impl.CandidateRepositoryImpl;

import javax.sql.DataSource;
@SpringBootApplication
public class Week4Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Week4Application.class, args);
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Our DataSource is = " + dataSource.getConnection().getCatalog());

    }

}
