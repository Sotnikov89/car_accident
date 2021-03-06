package ru.accident.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcConfig {
    @Bean
    public DataSource dsj(@Value("${jdbc.driver}") String driver,
                          @Value("${jdbc.url}") String url,
                          @Value("${jdbc.username}") String username,
                          @Value("${jdbc.password}") String password) {
        BasicDataSource dsj = new BasicDataSource();
        dsj.setDriverClassName(driver);
        dsj.setUrl(url);
        dsj.setUsername(username);
        dsj.setPassword(password);
        return dsj;
    }

    @Bean
    public JdbcTemplate jdbc(DataSource dsj) {
        return new JdbcTemplate(dsj);
    }
}
