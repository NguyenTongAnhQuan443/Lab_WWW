package vn.edu.iuh.fit.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private final EntityManager entityManager;
    private static Connection instance;

//    Constructor khoong tham so sua lai khoi tao
    public Connection() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

//    getter
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
        Connection  connection = new Connection();

        EntityManager entityManager = connection.getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
    }
}
