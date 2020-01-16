package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public class UserDao  implements IUserDao{

	@PersistenceContext
	private EntityManager mgr;

	@Override
	public User getUser(String email, String pass) {
		
		System.out.println("inside getUser--UserDao");
		String jpql = "select u from User u where u.email=:em and u.password=:pwd";
		return mgr.unwrap(Session.class).createQuery(jpql,User.class).setParameter("em", email)
				.setParameter("pwd", pass).getSingleResult();
	}
	
	
	
}
