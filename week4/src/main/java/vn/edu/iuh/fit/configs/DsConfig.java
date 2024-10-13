package vn.edu.iuh.fit.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DsConfig {

    @Bean
    @Scope("singleton")
    public DataSource mariadbDataSource() throws Throwable {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setUrl("jdbc:mariadb://localhost:3306/week4?createDatabaseIfNotExist=true");
        ds.setUsername("root");
        ds.setPassword("sapassword");
        return ds;
    }
}
