package com.lw.dcsjob.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.TimeZone;

/**
 * @author lw
 * @create 2024-09-24-20:38
 */
@SpringBootApplication(scanBasePackages = {"com.lw.dcsjob.server.starter.*"})
@EnableTransactionManagement(proxyTargetClass = true)
@Slf4j
public class DcsJobServerApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(DcsJobServerApplication.class, args);
    }

}
