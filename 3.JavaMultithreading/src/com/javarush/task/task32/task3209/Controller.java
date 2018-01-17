package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;

/**
 * Created by Taly on 15.01.2018.
 */
public class Controller {
	private View view;
	private HTMLDocument document;
	private File currentFile;

	public Controller(View view) {
		this.view = view;
	}
	public static void main(String[] args) {
		View view = new View();
		Controller controller = new Controller(view);
		view.setController(controller);
		view.init();
		controller.init();
	}

	public void init() { //инициализация контроллера

	}

	public void exit() {
		System.exit(0);
	}

	public HTMLDocument getDocument() {
		return document;
	}

	public void resetDocument() { //сброс текущего документа
		if (document != null) { // если документ существует
			//сбросить у него слушателя правок, которые можно отменить/вернуть
			document.removeUndoableEditListener(view.getUndoListener());
		}
		HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
		//создадим новый документ
		HTMLDocument document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
		//добавим ему слушателя правок
		document.addUndoableEditListener(view.getUndoListener());
		view.update(); //вызовем у представления метод update()
	}
}
