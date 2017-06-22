package org_khmeracademy.app.serviceimplement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import org_khmeracademy.app.model.User;
import org_khmeracademy.app.service.Userservice;
@Service("userservice")
public class UserserviceImp implements Userservice {
	
	private List<User>  list=new ArrayList<>();
	public UserserviceImp() {
		List<User> ulst = Arrays.asList(new User(1,"Thavid","thavid41@gmail.com"),
				new User(2,"Mony","Mony@gmail.com"),
				new User(3,"Mouykea","mouykea@gmail"),
				new User(168,"Chheng Chansopheaktra", "chansopheaktrachheng@gmail.com"));
		list.addAll(ulst);
	}
	@Override
	public List<User> Showuser() {
		
		return list;
	}

	@Override
	public void addUser(User user) {
		list.add(user);
	}

	@Override
	public void RemovUser(int id) {
		list.remove(getUsertById(id));
	}

	@Override
	public User getUsertById(int id) {
		return list.stream()
				.filter(user->user.id==id)
				.findFirst()
				.get();
	}

}
