package net.suranjan.buzzdeal.dao;

import java.util.List;

import net.suranjan.buzzdeal.model.Category;
import net.suranjan.buzzdeal.model.Product;

public interface ProductDao {

	public boolean insertProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int ProductId);
	public List<Product> getProductlist();

}
