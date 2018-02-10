package net.suranjan.buzzdeal.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.suranjan.buzzdeal.dao.UserDetailsDao;
import net.suranjan.buzzdeal.model.Product;
import net.suranjan.buzzdeal.model.UserDetails;

public class UserDetailsDaoTest {
	
	static UserDetailsDao ud;
	
	@BeforeClass
    public static void preExcecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("net.suranjan.buzzdeal");
		context.refresh();
	    ud=(UserDetailsDao) context.getBean("UserDetailsDaoImpl");
	}
	
	@Ignore
    @Test
    public void RegisterUserTest()
    {
	  UserDetails usd=new UserDetails();
	  usd.setCustomerName("Sandip Sharma");
	  usd.setAddress("Kolkata");
	  usd.setPassword("sandip@345");
	  usd.setRole("Admin");
	  usd.setEnabled(true);
	  usd.setEmailId("sandipswagger@gmail.com");
	  
	  assertTrue("Failed To Register User",ud.RegisterUser(usd));
    }
	
	   
	   @Test 
	   public void updateUserTest()
	    {
	      UserDetails usd= ud.getUser("1");
	      usd.setCustomerName("Suranjan Dey");
		  usd.setAddress("Kolkata");
		  usd.setPassword("SD@1997");
		  usd.setRole("Admin");
		  usd.setEnabled(true);
		  usd.setEmailId("suranjandey2012@gmail.com");
		  assertTrue("Failed To Update User",ud.UpdateUser(usd));
	  }
	
	
	
	
}
