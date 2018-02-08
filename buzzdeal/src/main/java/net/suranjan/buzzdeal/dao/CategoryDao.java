package net.suranjan.buzzdeal.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import net.suranjan.buzzdeal.model.Category;


public interface CategoryDao {
	
	public boolean insertCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategory(int CategoryId);
	public List<Category> getCategorylist();

}
