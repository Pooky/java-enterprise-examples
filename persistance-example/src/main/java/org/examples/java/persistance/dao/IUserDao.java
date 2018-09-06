package org.examples.java.persistance.dao;

import java.util.List;

import org.examples.java.persistance.entity.User;

public interface IUserDao {

	/**
	 * Save user to DB
	 * @param user
	 */
	void saveUser(User user);

	/**
	 * Get users as list
	 * @return
	 */
	List<User> getUsers();

}