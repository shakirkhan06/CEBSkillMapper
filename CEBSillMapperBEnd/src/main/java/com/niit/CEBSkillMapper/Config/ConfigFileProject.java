package com.niit.CEBSkillMapper.Config;

import org.springframework.context.annotation.Bean;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.niit")
@EnableTransactionManagement

public class ConfigFileProject 
{
	@Bean(name="dataSource")

	public DataSource dataSource() {
	    DriverManagerDataSource datasobj = new DriverManagerDataSource();
	    datasobj.setDriverClassName("org.h2.Driver");
	    datasobj.setUrl("jdbc:h2:tcp://localhost/~/SkillMapper");
	    datasobj.setUsername("sa");
	    datasobj.setPassword("");
	    return datasobj;
	 }

	public Properties getHibernateProperties() {
		Properties myproper=new Properties();
		myproper.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		myproper.setProperty("hibernate.show_sql", "true");
		myproper.setProperty("hibernate.hbm2ddl.auto", "update");
			return myproper;
	}

	@Bean(name="sessionFact")
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) 
	{
		LocalSessionFactoryBean sessionF=new LocalSessionFactoryBean();
		sessionF.setDataSource(dataSource);
		sessionF.setHibernateProperties(getHibernateProperties());
		sessionF.setPackagesToScan("com.niit");
		
		return sessionF;
	}

	@Bean(name="transactionMyManager")
	@Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFact) 
	{
		HibernateTransactionManager transactionobj=new HibernateTransactionManager();
		transactionobj.setSessionFactory(sessionFact);
		return transactionobj;
	}
}
