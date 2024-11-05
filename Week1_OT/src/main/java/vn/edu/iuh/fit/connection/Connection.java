package vn.edu.iuh.fit.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private final EntityManager entityManager;
    private static Connection instance;

    //    Constructor không tham số

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
}
