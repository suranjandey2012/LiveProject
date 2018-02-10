package net.suranjan.buzzdeal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Supplier_Details")
public class Supplier {

	@Id
	@GeneratedValue
	private int SupplierId;
	private String SupplierName;
	private String SupplierDesc;
	
	
	public int getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(int supplierId) {
		SupplierId = supplierId;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getSupplierDesc() {
		return SupplierDesc;
	}
	public void setSupplierDesc(String supplierDesc) {
		SupplierDesc = supplierDesc;
	}
	
}
