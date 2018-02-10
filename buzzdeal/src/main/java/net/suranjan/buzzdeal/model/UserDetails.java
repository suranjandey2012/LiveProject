package net.suranjan.buzzdeal.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Details")
public class UserDetails {
        @Id
        @GeneratedValue
		private String username;
		private String password;
		private String CustomerName;
		private String Role;
		private boolean Enabled;
		private String emailId;
		private String address;
		
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getCustomerName() {
			return CustomerName;
		}
		public void setCustomerName(String customerName) {
			CustomerName = customerName;
		}
		public String getRole() {
			return Role;
		}
		public void setRole(String role) {
			Role = role;
		}
		public boolean isEnabled() {
			return Enabled;
		}
		public void setEnabled(boolean enabled) {
			Enabled = enabled;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		
		
		
		
		
		
}


