package com.tech552.springbootactuatordemo.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

@Component
public class DBHealthIndicator implements HealthIndicator {


    @Override
    public Health health() {

        return isDbHealthy();
    }

    public Health isDbHealthy() {
        try (Connection conn = dataSource().getConnection()) {

            Statement stmt = conn.createStatement();
            stmt.execute("select 1");
        } catch (SQLException ex) {
            return Health.outOfService().withException(ex).build();
        }
        return Health.up().build();
    }

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:~/students-api-db2");
        dataSource.setUsername("sa");
        dataSource.setPassword("X1234567");

        return dataSource;
    }
}
