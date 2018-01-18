package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

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
		createNewDocument();
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

	public void setPlainText(String text) { //будет записывать переданный текст с html тегами в документ document
		resetDocument(); //сбросим документ
		// создадим новый ридер на базе переданного текста
		StringReader reader = new StringReader(text);
		try { //вызов метода read() из класса HTMLEditor() для вычитки данных из ридера в документ
			new HTMLEditorKit().read(reader, document, 0);
		} catch (Exception e) { //блокируем исключения и логируем их
			ExceptionHandler.log(e);
		}
	}

	public String getPlainText() { //должен получать текст из документа со всеми html тегами
		StringWriter stringWriter = new StringWriter(); //Создадим объект StringWriter
		HTMLEditorKit htmlEditorKit = new HTMLEditorKit(); //Создадим объект класса HTMLEditorKit
		try { //Перепишем все содержимое из документа document в созданный объект StringWriter
			htmlEditorKit.write(stringWriter, document, 0, document.getLength());
		} catch (Exception e) { //блокируем исключения и логируем их
			ExceptionHandler.log(e);
		}
		return stringWriter.toString(); //вернем полученный текст
	}

	public void createNewDocument() {
		view.selectHtmlTab(); // выбирем html вкладку
		resetDocument(); // сбросим документ
		view.setTitle("HTML редактор"); // установим заголовок окна
		view.resetUndo(); // сбросим правки в Undo-менеджере
		currentFile = null; //обнулим переменную

	}

	public void openDocument() {

	}

	public void saveDocument() {

	}

	public void saveDocumentAs() {

	}

}
