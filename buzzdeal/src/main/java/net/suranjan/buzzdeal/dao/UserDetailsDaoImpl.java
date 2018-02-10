package net.suranjan.buzzdeal.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.suranjan.buzzdeal.model.Supplier;
import net.suranjan.buzzdeal.model.UserDetails;

@Repository("UserDetailsDaoImpl")


public class UserDetailsDaoImpl implements UserDetailsDao {
	
	
	@Autowired
		SessionFactory sessionFactory;
		
		
		public UserDetailsDaoImpl(SessionFactory sessionfactory)
		{
			this.sessionFactory=sessionfactory;
		}
		
		
		@Transactional
		public boolean RegisterUser(UserDetails User) {
			try{
			     sessionFactory.getCurrentSession().save(User);
			     System.out.println("Registered User");
		 	     return true;
		      }catch(Exception e)
			    {
			     e.printStackTrace();
			     return false;
			}
			
		}
		
		@Transactional
		public boolean UpdateUser(UserDetails User) {
			try{
			      sessionFactory.getCurrentSession().update(User);
			      System.out.println("Updated User");
		 	      return true;
		       }catch(Exception e)
			  {
			     e.printStackTrace();
			     return false;
			}
		}

		public UserDetails getUser(String username) {
			Session session=sessionFactory.openSession();
			UserDetails User=(UserDetails) session.get(UserDetails.class,username);
			session.close();
			return User;
		}
        
		/*@Transactional
		public boolean ApproveUser(UserDetails user) {
			
			Session session=sessionFactory.openSession();
			UserDetails User=(UserDetails) session.get(UserDetails.class,username);
			if()
			
		}*/

}


