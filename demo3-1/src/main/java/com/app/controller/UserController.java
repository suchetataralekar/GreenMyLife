package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;
import com.app.pojos.LoginCheck;
import com.app.pojos.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserDao dao;
	
	@PostMapping("/login")
	public User validate(@RequestBody User log)
	{
		/*
		 * System.out.println(log); LoginCheck u1=(LoginCheck)log;
		 */
	
		try {
			System.out.println(log);
			User u = dao.getUser(log.getEmail(), log.getPassword());
			System.out.println(u);
			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
