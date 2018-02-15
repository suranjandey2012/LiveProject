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

import java.util.List;



public class CategoryDaotest {

	
	static CategoryDao categoryDao;
			
				@BeforeClass
			    public static void preExcecution()
				{
					AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
					context.scan("net.suranjan");
					context.refresh();
				    categoryDao=(CategoryDao) context.getBean("CategoryDao");
				}
						 
			    @Test
			    public void insertCategoryTest()
			    {
				  Category category=new Category();
				  category.setCategoryName("CarryBags");
				  category.setCategoryDesc("Vip Carry Bags");
				  assertTrue("Failed To Add Category",categoryDao.insertCategory(category));
			    }
			   @Ignore
			   @Test 
			   public void deleteCategoryTest()
			    {
				   Category category=categoryDao.getCategory(3);
				   assertTrue("Failed To Delete The Category",categoryDao.deleteCategory(category));
			     }
			   
			   @Ignore
			   @Test 
			   public void updateCategoryTest()
			    {
			      Category category=categoryDao.getCategory(2);
			      category.setCategoryName("Laptops");
			      category.setCategoryDesc("Lenovo Laptops");
			      categoryDao.getCategorylist();
			      assertTrue("Failed To Update Category",categoryDao.updateCategory(category));
			  }
			 
			   @Ignore
			   @Test 
			   public void listCategoryTest()
			    {
				   List<Category> listCategories=categoryDao.getCategorylist();
				   assertNotNull("Problems In Loading Product Category List",listCategories);
			     }
				
			
	}


