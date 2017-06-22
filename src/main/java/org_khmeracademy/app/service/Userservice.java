package org_khmeracademy.app.service;

import java.util.List;


import org_khmeracademy.app.model.User;
public interface Userservice {
	public List<User> Showuser();
	public void addUser(User user);
	public void RemovUser(int id);
	public User getUsertById(int id);
}
