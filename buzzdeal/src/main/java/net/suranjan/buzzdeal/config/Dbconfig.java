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

import net.suranjan.buzzdeal.dao.CategoryDao;
import net.suranjan.buzzdeal.dao.CategoryDaoImpl;
import net.suranjan.buzzdeal.dao.ProductDao;
import net.suranjan.buzzdeal.dao.ProductDaoImpl;
import net.suranjan.buzzdeal.dao.SupplierDao;
import net.suranjan.buzzdeal.dao.SupplierDaoImpl;
import net.suranjan.buzzdeal.dao.UserDetailsDao;
import net.suranjan.buzzdeal.dao.UserDetailsDaoImpl;
import net.suranjan.buzzdeal.model.Category;
import net.suranjan.buzzdeal.model.Product;
import net.suranjan.buzzdeal.model.Supplier;
import net.suranjan.buzzdeal.model.UserDetails;

@Configuration
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
	
	
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
       Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder sessionfactory=new LocalSessionFactoryBuilder(getDataSource());
		sessionfactory.addProperties(hibernateProp);
		
		sessionfactory.addAnnotatedClass(Category.class);
		sessionfactory.addAnnotatedClass(Supplier.class);
		sessionfactory.addAnnotatedClass(Product.class);
		sessionfactory.addAnnotatedClass(UserDetails.class);
		SessionFactory sessionfac=sessionfactory.buildSessionFactory();
		System.out.println("Built SessionFactory");
		return sessionfac;
	}
	
	
	
	@Bean(name="CategoryDao")
	public CategoryDao getCategoryDAO(SessionFactory sessionFactory)
	{
		return new CategoryDaoImpl(sessionFactory);
     }
	
	@Bean(name="SupplierDao")
	public SupplierDao getSupplierDAO(SessionFactory sessionFactory)
	{
		return new SupplierDaoImpl(sessionFactory);
	}
	
	@Bean(name="ProductDao")
	public ProductDao getProductDAO(SessionFactory sessionFactory)
	{
		return new ProductDaoImpl(sessionFactory);
	}
	
	@Bean(name="UserDetailsDao")
	public UserDetailsDao getUserDetailsDAO(SessionFactory sessionFactory)
	{
		return new UserDetailsDaoImpl(sessionFactory);
	}
	
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransaction(SessionFactory sessionfactory)
	{
		System.out.println("Transaction Manager");
		HibernateTransactionManager tm=new HibernateTransactionManager(sessionfactory);
		return tm;
	}

}