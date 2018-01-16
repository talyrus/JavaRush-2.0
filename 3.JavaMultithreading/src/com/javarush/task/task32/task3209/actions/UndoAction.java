package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Taly on 16.01.2018.
 */
public class UndoAction extends AbstractAction {
	private View view;

	public UndoAction(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
