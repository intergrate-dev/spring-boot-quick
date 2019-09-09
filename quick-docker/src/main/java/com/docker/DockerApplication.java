package com.docker;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * User: vector
 * Data: 2018/1/17
 * Time: 13:49
 * Description:
 */
@SpringBootApplication
@RestController
public class DockerApplication {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String hello() {
        logger.info("接收到请求》》》》》》》》》》》》》》》》》》》》》》》");
        return "<h1>Hello Spring-Boot Maven Docker</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class);
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(
            @Value("${spring.application.name}") String applicationName) {
        return (registry) -> registry.config().commonTags("application", applicationName);
    }
}
