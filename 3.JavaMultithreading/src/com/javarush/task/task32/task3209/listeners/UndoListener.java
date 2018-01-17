package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by Taly on 17.01.2018.
 * класс будет следить за правками, которые можно отменить или вернуть.
 */
public class UndoListener implements UndoableEditListener {
	private UndoManager undoManager;

	@Override
	//должен из переданного события получать правку и добавлять ее в undoManager
	public void undoableEditHappened(UndoableEditEvent e) {
		undoManager.addEdit(e.getEdit());
	}

	public UndoListener(UndoManager undoManager) {
		this.undoManager = undoManager;
	}
}
