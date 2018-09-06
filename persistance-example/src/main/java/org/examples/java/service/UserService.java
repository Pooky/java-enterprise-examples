package org.examples.java.service;

import java.util.List;

import javax.inject.Inject;

import org.examples.java.persistance.dao.IUserDao;
import org.examples.java.persistance.entity.User;

/**
 * User service
 */
public class UserService implements IUserService {

	@Inject
	private IUserDao dao;

	public List<User> getUsers() {
		return dao.getUsers();
	}
	
	public void saveUser(User user) {
		dao.saveUser(user);
	}


}
