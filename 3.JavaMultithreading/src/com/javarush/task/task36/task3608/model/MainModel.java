package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

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
		modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
	}
}
