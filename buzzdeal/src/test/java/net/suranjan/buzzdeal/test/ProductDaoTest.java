package net.suranjan.buzzdeal.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.suranjan.buzzdeal.dao.ProductDao;
import net.suranjan.buzzdeal.dao.SupplierDao;
import net.suranjan.buzzdeal.model.Product;
import net.suranjan.buzzdeal.model.Supplier;

public class ProductDaoTest {

static ProductDao Productdao;
	
	@BeforeClass
    public static void preExcecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("net.suranjan.buzzdeal");
		context.refresh();
	    Productdao=(ProductDao) context.getBean("ProductDao");
	}
	
	@Ignore	 
    @Test
    public void insertProductTest()
    {
	  Product product =new Product();
	  product.setProductName("Nikon Coolpix");
	  product.setProductDesc("500 Megapixcel Camera");
	  product.setCategory("Camera");
	  product.setSupplier("Nikon");
	  product.setPrice(56000);
	  product.setStock(30);
	  assertTrue("Failed To Add Product",Productdao.insertProduct(product));
    }
   
   @Ignore
   @Test 
   public void deleteProductTest()
    {
	   Product product=Productdao.getProduct(1);
	   assertTrue("Failed To Delete The Supplier",Productdao.deleteProduct(product));
     }
   
   
   @Test 
   public void updateProductTest()
    {
      Product product=Productdao.getProduct(2);
      product.setProductName("HCL");
	  product.setProductDesc("Core I7 processor with 8Gb RAM ");
	  product.setCategory("Laptop");
	  product.setSupplier("HCL");
	  product.setPrice(63000);
	  product.setStock(15);
      assertTrue("Failed To Update Product",Productdao.updateProduct(product));
  }
 
   @Ignore
   @Test 
   public void listProductTest()
    {
	   List<Product> listProduct=Productdao.getProductlist();
	   assertNotNull("Problems In Loading Product Supplier List",listProduct);
     }
	



}
