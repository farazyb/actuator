package com.tech552.springbootactuatordemo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class PersonDbConfig {

    @Bean(name = "personDataSource")
    @ConfigurationProperties(prefix = "datasourcet.second")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean
    public JdbcTemplate personJdbcTemplate(@Qualifier("personDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
