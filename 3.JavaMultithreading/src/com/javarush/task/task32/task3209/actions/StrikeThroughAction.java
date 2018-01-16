package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by Taly on 16.01.2018.
 * Класс отвечает за стиль текста "Зачеркнутый"
 */
public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {
	public StrikeThroughAction() {
		super("Зачеркнутый");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
