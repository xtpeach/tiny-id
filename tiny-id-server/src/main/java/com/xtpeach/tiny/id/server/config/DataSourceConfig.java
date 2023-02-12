package com.xtpeach.tiny.id.server.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

/**
 * @author xtpeach
 */
@Configuration
public class DataSourceConfig {

    @Resource
    private DefaultDataSourceProperties defaultDataSourceProperties;

    @Resource
    private HikariProperties hikariProperties;

    @Bean(name = "dataSource")
    @Primary
    public HikariDataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        // base config
        hikariConfig.setDriverClassName(defaultDataSourceProperties.getDriver());
        // 数据库用户名加密
        hikariConfig.setUsername(defaultDataSourceProperties.getUsername());
        // 数据库密码加密
        hikariConfig.setPassword(defaultDataSourceProperties.getPassword());
        hikariConfig.setJdbcUrl(defaultDataSourceProperties.getUrl());
        // hikari config
        hikariConfig.setMinimumIdle(hikariProperties.getMinimumIdle());
        hikariConfig.setMaximumPoolSize(hikariProperties.getMaximumPoolSize());
        hikariConfig.setAutoCommit(hikariProperties.getAutoCommit());
        hikariConfig.setIdleTimeout(hikariProperties.getIdleTimeout());
        hikariConfig.setPoolName(hikariProperties.getPoolName());
        hikariConfig.setMaxLifetime(hikariProperties.getMaxLifetime());
        hikariConfig.setConnectionTimeout(hikariProperties.getConnectionTimeout());
        hikariConfig.setConnectionTestQuery(hikariProperties.getConnectionTestQuery());
        hikariConfig.setValidationTimeout(hikariProperties.getValidationTimeout());
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

        return hikariDataSource;
    }

}

