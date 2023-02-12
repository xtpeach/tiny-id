package com.xtpeach.tiny.id.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xtpeach
 */
@EnableAsync
@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = {
        "com.xtpeach.tiny.id.server.dao.entity"
})
@EnableTransactionManagement
public class TinyIdServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyIdServerApplication.class, args);
    }

}
