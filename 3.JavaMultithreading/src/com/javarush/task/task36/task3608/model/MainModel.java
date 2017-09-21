package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by Taly on 21.09.2017.
 */
public class MainModel implements Model {
	private UserService userService = new UserServiceImpl();
	private ModelData modelData = new ModelData();

	@Override
	public ModelData getModelData() {
		return this.modelData;
	}

	@Override
	public void loadUsers() {
		modelData.setDisplayDeletedUserList(false);
		modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
	}

	@Override
	public void loadDeletedUsers() {
		List<User> users = userService.getAllDeletedUsers();
		modelData.setDisplayDeletedUserList(true);
		modelData.setUsers(users);
	}

	public void loadUserByd(long userId) {
		User user = userService.getUsersById(userId);
		modelData.setActiveUser(user);
	}

	@Override
	public void loadUserById(long userId) {
		User user = userService.getUsersById(userId);
		modelData.setActiveUser(user);
	}
}
