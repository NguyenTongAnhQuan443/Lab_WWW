package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.connectDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private final EntityManager entityManager;
    private static Connection connection;

    private Connection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public static Connection getInstance() {
        if (connection == null)
            connection = new Connection();
        return connection;
    }
}
