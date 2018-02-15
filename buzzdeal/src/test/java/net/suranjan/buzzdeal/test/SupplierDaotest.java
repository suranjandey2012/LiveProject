package net.suranjan.buzzdeal.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.suranjan.buzzdeal.dao.SupplierDao;
import net.suranjan.buzzdeal.model.Supplier;


public class SupplierDaotest {

	static SupplierDao supplierDao;
	
	@BeforeClass
    public static void preExcecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("net.suranjan");
		context.refresh();
	    supplierDao=(SupplierDao) context.getBean("SupplierDao");
	}
	
	@Ignore	 
    @Test
    public void insertSupplierTest()
    {
	  Supplier supplier =new Supplier();
	  supplier.setSupplierName("Nikon");
	  supplier.setSupplierDesc("500MegaPixelCamera");
	  assertTrue("Failed To Add Supplier",supplierDao.insertSupplier(supplier));
    }
   @Ignore
   @Test 
   public void deleteSupplierTest()
    {
	   Supplier supplier=supplierDao.getSupplier(1);
	   assertTrue("Failed To Delete The Supplier",supplierDao.deleteSupplier(supplier));
     }
   
   @Ignore
   @Test 
   public void updateSupplierTest()
    {
      Supplier supplier=supplierDao.getSupplier(2);
      supplier.setSupplierName("Lenovo");
      supplier.setSupplierDesc("Core I5 Processor");
      supplierDao.getSupplierlist();
      assertTrue("Failed To Update Supplier",supplierDao.updateSupplier(supplier));
  }
 
   
   @Test 
   public void listSupplierTest()
    {
	   List<Supplier> listSupplier=supplierDao.getSupplierlist();
	   assertNotNull("Problems In Loading Product Supplier List",listSupplier);
     }
	


}
