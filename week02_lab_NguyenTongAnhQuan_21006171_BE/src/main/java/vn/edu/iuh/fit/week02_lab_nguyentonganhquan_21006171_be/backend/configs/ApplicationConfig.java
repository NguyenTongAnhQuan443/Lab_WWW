package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.configs;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.connectDB.Connection;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    public ApplicationConfig() {
        Connection.getInstance().getEntityManager();
    }
}
