package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.connectDB;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private static Connection instance;
    private EntityManagerFactory entityManagerFactory;

    public Connection(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }
    public static Connection getInstance() {
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
