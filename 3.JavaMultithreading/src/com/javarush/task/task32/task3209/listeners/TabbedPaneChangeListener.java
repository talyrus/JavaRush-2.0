package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Taly on 15.01.2018.
 */
public class TabbedPaneChangeListener implements ChangeListener {
	//класс будет слушать и обрабатывать изменения состояния панели вкладок.
	private View view;

	@Override
	public void stateChanged(ChangeEvent e) {
		view.selectedTabChanged();
	}

	public TabbedPaneChangeListener(View view) {
		this.view = view;
	}
}
