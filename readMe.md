
## 
###  3-1使用h2内存数据库，通过`http://localhost:8080/h2-console`访问


> pom文件配置h2 

```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

> 初始化h2配置 

```
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
```


### 如果使用Mariadb，可以使用此配置 连同application.yml

> 依赖配置

```xml
<!-- jpa，使用eclipselink的jpa实现替换hibernate的jpa实现（也可以不替换）-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <exclusions>
        <exclusion>
            <artifactId>hibernate-entitymanager</artifactId>
            <groupId>org.hibernate</groupId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.eclipse.persistence</groupId>
    <artifactId>eclipselink</artifactId>
    <version>2.5.2</version>
</dependency>
	<!-- 注释-->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
     
      	<!-- 放开-->
     
<dependency>
    <groupId>org.mariadb.jdbc</groupId>
    <artifactId>mariadb-java-client</artifactId>
    <version>2.5.1</version>
</dependency>
```

> 配置文件，注意数据库的用户名密码要正确

```yml
spring:
    datasource:
        hikari:
        driver-class-name: org.mariadb.jdbc.Driver
        jdbc-url: jdbc:mariadb://127.0.0.1:3306/test
        username: root
        password: root
    # jap配置
    jpa: 
        hibernate:
        ddl-auto: update
        show-sql: true
```
     /**
     * 

> Bean配置

```java
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public HikariDataSource dataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }
```