package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by Taly on 20.09.2017.
 */
public class UsersView implements View {
	private Controller controller;

	public void fireEventShowAllUsers() {
		controller.onShowAllUsers();

	}

	public void fireEventShowDeletedUsers() {
		controller.onShowAllDeletedUsers();
	}


	@Override
	public void refresh(ModelData modelData) {
		if (modelData.isDisplayDeletedUserList()) {
			System.out.println("All deleted users:");
		} else {
			System.out.println("All users:");
		}

		for (int i = 0; i < modelData.getUsers().size(); i++) {
			System.out.println("\t" + modelData.getUsers().get(i));
		}
		System.out.println("===================================================");
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}


	public void fireEventOpenUserEditForm(long id) {
		controller.onOpenUserEditForm(id);
	}


}
