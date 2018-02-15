package net.suranjan.buzzdeal.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.suranjan.buzzdeal.model.Category;


public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	
	@Transactional
	@Override
	public boolean insertCategory(Category category) {
		
	try{	
		sessionFactory.getCurrentSession().save(category);
		System.out.println("Inserted Category");
		return true;
	}catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	}
	
	@Transactional
	@Override
	public boolean deleteCategory(Category category) {
		
	try{	
		sessionFactory.getCurrentSession().delete(category);
		System.out.println("Deleted Category");
		return true;
	}catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	
	}
    
   
     
    @Transactional
    @Override
	public boolean updateCategory(Category category) {
    	
    	try{
    	    sessionFactory.getCurrentSession().update(category);
    	    System.out.println("Updated Category");
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
    
    
    @Override
	public Category getCategory(int CategoryId) {
    	Session session=sessionFactory.openSession();
    	Category c=(Category) session.get(Category.class,CategoryId);
    	session.close();
		return c;
	}
    
    
    @Override
	public List<Category> getCategorylist() {
    	
		Session session=sessionFactory.openSession();
    	 Query q= session.createQuery("from Category");
    	 List<Category> list=q.list();
    	 for(Category c:list)
    	 {
    		System.out.print(c.getCategoryId()+" ");
    	    System.out.print(c.getCategoryName()+" ");
    	    System.out.println(c.getCategoryDesc());
    	}
    	session.close();
		return list;
    	}
    	
	

 }
	


