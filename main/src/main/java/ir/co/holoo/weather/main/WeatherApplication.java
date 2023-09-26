package ir.co.holoo.weather.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        exclude = {
                MessageSourceAutoConfiguration.class,
        },
        proxyBeanMethods = false,
        scanBasePackages = {
                "ir.co.holoo.weather.controller",
                "ir.co.holoo.weather.persistence",
                "ir.co.holoo.weather.service",
                "ir.co.holoo.weather.main"
        })
@EntityScan(basePackages = {"ir.co.holoo.weather.model"})
@ConfigurationPropertiesScan(basePackages = {"ir.co.holoo.weather.service.properties"})
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = {"ir.co.holoo.weather.persistence.jpa"})
public class WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }
}
