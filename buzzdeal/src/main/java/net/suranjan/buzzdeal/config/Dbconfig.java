package net.suranjan.buzzdeal.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.suranjan.buzzdeal.model.Category;
import net.suranjan.buzzdeal.dao.CategoryDaoImpl;

@Configuration
@ComponentScan("net.suranjan.buzzdeal")
@EnableTransactionManagement
public class Dbconfig {
	
	public DataSource getDataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("sa");
		datasource.setPassword("1234");
		System.out.println("DataSource Created");
		return datasource;
	}
	
	public Properties getHibernateProprties()
	{
		
		Properties p=new Properties();
	    p.setProperty("hibernate.hbm2ddl.auto","update");
	    p.setProperty("hibernate.show_sql","true");
	    p.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	    System.out.println("Hibernate Properties Set");
	    return p;
				
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder sessionfactory=new LocalSessionFactoryBuilder(getDataSource());
		sessionfactory.addProperties(getHibernateProprties());
		sessionfactory.addAnnotatedClass(Category.class);
		SessionFactory sessionfac=sessionfactory.buildSessionFactory();
		System.out.println("Built SessionFactory");
		return sessionfac;
	}
	
	
	
	@Bean(name="CategoryDaoImpl")
	public CategoryDaoImpl getCategoryDAO(SessionFactory sessionFactory)
	{
		return new CategoryDaoImpl(sessionFactory);
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransaction(SessionFactory sessionfactory)
	{
		System.out.println("Transaction Manager");
		HibernateTransactionManager tm=new HibernateTransactionManager(sessionfactory);
		return tm;
	}

}
