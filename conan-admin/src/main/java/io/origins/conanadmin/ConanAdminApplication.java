package io.origins.conanadmin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
@MapperScan("io.origins.conanadmin.mapper")
public class ConanAdminApplication {
    @Value("${spring.cloud.nacos.config.group}")

    public static void main(String[] args) {
        SpringApplication.run(ConanAdminApplication.class, args);
        log.info("Conan Admin Application Started");
    }

}
