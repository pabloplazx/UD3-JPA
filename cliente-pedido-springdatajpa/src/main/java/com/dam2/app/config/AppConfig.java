package com.dam2.app.config;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.dam2")
@EnableJpaRepositories("com.dam2.repo") //ESTO ACTIVA TRANSACCIONES TAMBIÉN...
@EnableTransactionManagement //SIN ESTA ANOTACIÓN NO FUNCIONAN LAS ANOTACIONES
//@Transactional de los servicios
public class AppConfig {

 @Bean
 public DataSource dataSource() {
  DriverManagerDataSource ds = new DriverManagerDataSource();
  ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
  ds.setUrl("jdbc:mysql://localhost:3306/demo_jpa");
  ds.setUsername("root");
  ds.setPassword("1234");
  return ds;
 }

 @Bean
 public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
  LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
  emf.setDataSource(ds);
  emf.setPackagesToScan("com.dam2.model");

  HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
  adapter.setShowSql(true);
  adapter.setGenerateDdl(true);
  emf.setJpaVendorAdapter(adapter);

  Properties props = new Properties();
  props.put("hibernate.hbm2ddl.auto", "update");
  props.put("hibernate.format_sql", "true");
  props.put("hibernate.show_sql", "true");

  emf.setJpaProperties(props);
  return emf;
 }

 @Bean
 public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
  return new JpaTransactionManager(emf);
 }
}
