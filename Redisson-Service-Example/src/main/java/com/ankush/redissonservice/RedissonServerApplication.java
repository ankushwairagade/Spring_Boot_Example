package com.ankush.redissonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import javax.sql.DataSource;
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = { "com.ankush.*"})
public class RedissonServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedissonServerApplication.class, args);
	}

	 @Bean(value = "datasource")
	    @ConfigurationProperties("app.datasource")
	    public DataSource dataSource() {
	        return DataSourceBuilder.create().build();
	    }
}
