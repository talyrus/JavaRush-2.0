package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by Taly on 16.01.2018.
 */
public class TextEditMenuListener implements MenuListener {
	private View view;

	@Override
	public void menuSelected(MenuEvent menuEvent) {
		// из переданного параметра получим обект, над которым будем совершать действия - Меню
		JMenu menu = (JMenu) menuEvent.getSource();
		// создадим массив компонентов и получим содержимое меню (все пункты)
		Component[] elements = menu.getMenuComponents();
		for (Component el : elements) { //переберм все элементы массива и установим значение
			el.setEnabled(view.isHtmlTabSelected());
		}

	}

	@Override
	public void menuDeselected(MenuEvent e) {

	}

	@Override
	public void menuCanceled(MenuEvent e) {

	}

	public TextEditMenuListener(View view) {
		this.view = view;
	}
}
