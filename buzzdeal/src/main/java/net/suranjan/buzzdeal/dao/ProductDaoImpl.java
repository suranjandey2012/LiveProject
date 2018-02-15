package net.suranjan.buzzdeal.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.suranjan.buzzdeal.model.Category;
import net.suranjan.buzzdeal.model.Product;


public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	
	
	@Transactional
	@Override
	public boolean insertProduct(Product product) {
		
		try{	
			sessionFactory.getCurrentSession().save(product);
			System.out.println("Inserted Product");
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteProduct(Product product) {
		try{	
			sessionFactory.getCurrentSession().delete(product);
			System.out.println("Deleted Product");
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	@Override
	public boolean updateProduct(Product product) {
		try{
    	    sessionFactory.getCurrentSession().update(product);
    	    System.out.println("Updated Product");
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product getProduct(int ProductId) {
		Session session=sessionFactory.openSession();
    	Product c=(Product) session.get(Product.class,ProductId);
    	session.close();
		return c;
		
	}
    
	@Override
	public List<Product> getProductlist() {
	
		
		Session session=sessionFactory.openSession();
    	 Query q= session.createQuery("from Product");
    	 List<Product> list=q.list();
    	 for(Product p:list)
    	 {
    		System.out.print(p.getProductId()+" ");
    	    System.out.print(p.getProductName()+" ");
    	    System.out.print(p.getProductDesc()+" ");
    	    System.out.print(p.getSupplier()+" ");
    	    System.out.print(p.getCategory()+" ");
    	    System.out.print(p.getPrice()+" ");
    	    System.out.println(p.getStock());
    	}
    	session.close();
		return list;
    	}
    	
}


