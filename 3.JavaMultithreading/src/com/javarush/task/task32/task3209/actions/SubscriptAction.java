package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by Taly on 16.01.2018.
 * отвечает за стиль  "Подстрочный знак"
 */
public class SubscriptAction extends StyledEditorKit.StyledTextAction {

	public SubscriptAction() {
		super("Подстрочный знак");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
