package com.jpa.jpaSpring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class SourceConfig {
	String url = "jdbc:mysql://localhost:3306/springData";
	String username = "root";
	String password = "1301420jp";
	String driverClassName = "com.mysql.cj.jdbc.Driver";
	String databasePlatform = "org.hibernate.dialect.MySQL5Dialect";
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}
	@Bean
	public JpaVendorAdapter japaVendorAdapter() {
		HibernateJpaVendorAdapter jpaAdapter = new HibernateJpaVendorAdapter();
		
		jpaAdapter.setDatabase(Database.MYSQL);
		jpaAdapter.setShowSql(true);
		jpaAdapter.setGenerateDdl(true);
		jpaAdapter.setDatabasePlatform(databasePlatform);
		jpaAdapter.setPrepareConnection(true);
		
		return jpaAdapter;
	}
}
