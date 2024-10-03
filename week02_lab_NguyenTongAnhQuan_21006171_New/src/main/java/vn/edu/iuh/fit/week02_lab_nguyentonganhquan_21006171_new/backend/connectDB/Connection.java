package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.connectDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
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
        Connection connection = Connection.getInstance();

        EntityManager entityManager = connection.getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
    }
}
