package net.suranjan.buzzdeal.test;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import junit.framework.TestCase;
import net.suranjan.buzzdeal.dao.CategoryDao;
import net.suranjan.buzzdeal.model.Category;

import static org.junit.Assert.*;



public class CategoryDaotest {

	
	static CategoryDao categoryDao;
			
				@BeforeClass
			    public static void preExcecution()
				{
					AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
					context.scan("net.suranjan.buzzdeal");
					context.refresh();
				    categoryDao=(CategoryDao) context.getBean("CategoryDaoImpl");
				}
				@Ignore		 
			    @Test
			    public void insertCategoryTest()
			    {
				  Category category=new Category();
				  category.setCategoryName("Camera");
				  category.setCategoryDesc("DSLR Camera");
				  assertTrue("Failed To Add Category",categoryDao.insertCategory(category));
			    }
			   @Ignore
			   @Test 
			   public void deleteCategoryTest()
			    {
				   Category category=categoryDao.getCategory(3);
				   assertTrue("Failed To Delete The Category",categoryDao.deleteCategory(category));
			     }
			   
			   
			   @Test 
			   public void updateCategoryTest()
			    {
			      Category category=categoryDao.getCategory(2);
			      category.setCategoryName("Laptops");
			      category.setCategoryDesc("Lenovo Laptops");
			      categoryDao.getCategorylist();
			      assertTrue("Failed To Update Category",categoryDao.updateCategory(category));
			  }
			 
			
				
			
	}


