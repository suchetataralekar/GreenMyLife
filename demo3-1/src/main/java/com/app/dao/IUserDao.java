package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {

	User getUser(String email, String pass);
}
