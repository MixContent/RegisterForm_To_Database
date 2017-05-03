package com.khan.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.khan.hibernate.model.User;


public class UserDao 
{
	public void addUserDetails(String id, String userName, String password, String gender, String qualification, String email, String phone,String city)
	{
		try{
		//configure hibernate
		Configuration conf=new Configuration();
		conf.configure("com/khan/hibernate/config/hibernate.cfg.xml");
		SessionFactory factory=conf.buildSessionFactory();
		
		//open session
		Session session=factory.openSession();

		//start transaction
		Transaction transaction=session.beginTransaction();
		
		User user=new User();
		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		user.setGender(gender);
		user.setQualification(qualification);
		user.setEmail(email);
		user.setPhone(phone);
		user.setCity(city);
	
		
		session.save(user);
		transaction.commit();
		session.close();
		System.out.println("\n\n Detail Added \n");
	}
		catch (Exception e) {
			System.out.println("Something went wrong..");
		}
	}
}
