package net.suranjan.buzzdeal.dao;

import java.util.List;

import net.suranjan.buzzdeal.model.Category;
import net.suranjan.buzzdeal.model.Supplier;

public interface SupplierDao {
	public boolean insertSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public Supplier getSupplier(int SupplierId);
	public List<Supplier> getSupplierlist();
}
