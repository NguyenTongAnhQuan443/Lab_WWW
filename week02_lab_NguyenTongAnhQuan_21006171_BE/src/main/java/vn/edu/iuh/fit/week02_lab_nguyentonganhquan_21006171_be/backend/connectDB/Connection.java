package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.connectDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Connection {
    private final EntityManager entityManager;
    private static Connection connection;

    private Connection() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public static Connection getInstance() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection1 = Connection.getInstance();

        EntityManager entityManager1 = connection1.getEntityManager();

        entityManager1.getTransaction().begin();

        entityManager1.getTransaction().commit();
//        entityManager1.close();
    }
}
