package org.examples.java.service;

import java.util.List;

import org.examples.java.persistance.entity.User;

public interface IUserService {

	List<User> getUsers();

	void saveUser(User user);

}