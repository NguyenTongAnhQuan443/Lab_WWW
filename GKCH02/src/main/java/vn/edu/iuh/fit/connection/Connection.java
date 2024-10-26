package vn.edu.iuh.fit.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private EntityManager entityManager;
    private static Connection instance;

    public Connection() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public static Connection getInstance() {
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }

    public static void main(String[] args) {
        Connection connection = new Connection();

        EntityManager entityManager1 = Connection.getInstance().getEntityManager();

        entityManager1.getTransaction().begin();
        entityManager1.getTransaction().commit();
    }
}
