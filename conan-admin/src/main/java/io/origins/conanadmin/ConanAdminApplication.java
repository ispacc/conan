package io.origins.conanadmin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
@MapperScan("io.origins.conanadmin.mapper")
public class ConanAdminApplication {
    // 打印 xms xmx xmn
    static {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        int core = Runtime.getRuntime().availableProcessors();
        log.info("maxMemory: {}M, totalMemory: {}M, freeMemory: {}M, core: {}", maxMemory / 1024 / 1024, totalMemory / 1024 / 1024, freeMemory / 1024 / 1024, core);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConanAdminApplication.class, args);
    }

}
