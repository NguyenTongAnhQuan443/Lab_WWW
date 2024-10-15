package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.iuh.fit.models.Candidate1;
import vn.edu.iuh.fit.repositories.Impl.CandidateRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Week4Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Week4Application.class, args);
    }

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private CandidateRepositoryImpl candidateRepositoryImpl;

    @Override
    public void run(String... args) throws Exception {

//        Candidate1 candidate = new Candidate1("Nguyen", "Van", "A", LocalDate.of(1999, 1, 1), "nguyenvana@gmail.com", "123 Nguyen Van Linh", "0123456789");
//
//        if (candidateRepositoryImpl.createCandidate(candidate)){
//            System.out.println("Candidate created successfully");
//        } else {
//            System.out.println("Candidate creation failed");
//        }
//
//        List<Candidate1> lst = candidateRepositoryImpl.findAll();
//        lst.forEach(System.out::println);

    }

}
