package com.xtpeach.tiny.id.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 数据库配置信息
 *
 * @author xtpeach
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DefaultDataSourceProperties {

    private String driver;
    private String url;
    private String username;
    private String password;

    public String getDriver() {
        return driver;
    }

    public DefaultDataSourceProperties setDriver(String driver) {
        this.driver = driver;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DefaultDataSourceProperties setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DefaultDataSourceProperties setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DefaultDataSourceProperties setPassword(String password) {
        this.password = password;
        return this;
    }
}
