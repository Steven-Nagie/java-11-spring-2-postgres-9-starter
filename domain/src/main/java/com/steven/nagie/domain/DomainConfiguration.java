package com.steven.nagie.domain;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {
    "com.steven.nagie.domain"
})
@EntityScan({"com.steven.nagie.schema"})
public class DomainConfiguration {
  
  private String[] PACKAGES_TO_SCAN = {};
  
  @Autowired
  private Environment environment;
  
  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
    LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
    lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
    lcemfb.setDataSource(dataSource());
    lcemfb.setPersistenceUnitName("myJpaPersistenceUnit");
    lcemfb.setPackagesToScan(PACKAGES_TO_SCAN);
    lcemfb.setJpaProperties(hibernateProperties());
    return lcemfb;
  }
  
  @Bean
  public JpaVendorAdapter getJpaVendorAdapter() {
    JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    return adapter;
  }
  
  @Bean(name = "transactionManager")
  public PlatformTransactionManager txManager() {
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
        getEntityManagerFactoryBean().getObject());
    return jpaTransactionManager;
  }
  
  /************* End Spring JPA config details **************/
  
  @Bean
  public DataSource dataSource() {
    // TODO: Better way to configure?
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver"));
    StringBuilder jdbcUrl = new StringBuilder("jdbc:postgresql://" + environment.getRequiredProperty("jdbc.host") + ":");
    jdbcUrl.append(environment.getRequiredProperty("jdbc.port"));
    jdbcUrl.append("/" + environment.getRequiredProperty("jdbc.databaseName"));
    dataSource.setUrl(jdbcUrl.toString());
    dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
    dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
    return dataSource;
  }
  
  private Properties hibernateProperties() {
    // TODO: Determine if these properties are necessary
    Properties properties = new Properties();
    properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
    properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
    properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
    return properties;
  }
  
  @PostConstruct
  public void migrateFlyway() {
    Flyway.configure()
        .dataSource(dataSource())
        .locations("classpath:db/migration/security")
        .schemas("security")
        .table("security_version")
        .baselineOnMigrate(true)
        .load()
        .migrate();
  }
}
