package net.suranjan.buzzdeal.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.suranjan.buzzdeal.model.Supplier;
import net.suranjan.buzzdeal.model.UserDetails;



public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	SessionFactory sessionFactory;

	public UserDetailsDaoImpl(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	@Transactional
	@Override
	public boolean RegisterUser(UserDetails User) {
		try {
			sessionFactory.getCurrentSession().save(User);
			System.out.println("Registered User");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	@Override
	public boolean UpdateUser(UserDetails User) {
		try {
			sessionFactory.getCurrentSession().update(User);
			System.out.println("Updated User");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserDetails getUser(String username) {
		Session session = sessionFactory.openSession();
		UserDetails User = (UserDetails) session.get(UserDetails.class, username);
		session.close();
		return User;
	}

	@Transactional
	@Override
		public boolean ApproveUser(UserDetails user) {
			try{
		        Session session=sessionFactory.openSession();
			     UserDetails User=(UserDetails) session.get(UserDetails.class,user.getUsername());
			     if(User.isEnabled()==true)
			       {
				     System.out.println("User is approved");
				      return true;
			       }
			         else
			          {
				        return false;
			          }
			}catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}

}
