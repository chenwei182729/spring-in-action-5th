package com.cninfo.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class H2DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                /**
                 * 默认会加addScript classpath:schema.sql classpath:data.sql
                 * 如果文件名不是这两个，可以通过addScript指定
                 * 注意sql文件的顺序，schema是建表语句，data.sql是插入数据的语句
                 * */
//                .addScript("classpath:schema.sql")
//                .addScript("classpath:data.sql")
//                .addDefaultScripts()
                .build();
    }

    /**
     * 如果使用Mariadb，可以使用此配置 连同application.yml
     * spring:
     *   datasource:
     *     hikari:
     *       driver-class-name: org.mariadb.jdbc.Driver
     *       jdbc-url: jdbc:mariadb://127.0.0.1:3306/test
     *       username: root
     *       password: root
     *
     *
     *     <dependency>
     * 			<groupId>com.h2database</groupId>
     * 			<artifactId>h2</artifactId>
     * 			<scope>runtime</scope>
     * 		</dependency>
     *
     * 	放开
     *
     * 	<dependency>
     * 					<groupId>org.mariadb.jdbc</groupId>
     * 					<artifactId>mariadb-java-client</artifactId>
     * 					<version>2.5.1</version>
     * 				</dependency>
     */
//    @Bean
//    @ConfigurationProperties("spring.datasource.hikari")
//    public HikariDataSource dataSource() {
//        return DataSourceBuilder.create()
//                .type(HikariDataSource.class)
//                .build();
//    }
}
