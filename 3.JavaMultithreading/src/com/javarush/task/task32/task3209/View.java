package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taly on 15.01.2018.
 */
public class View extends JFrame implements ActionListener {
	private Controller controller;
	private JTabbedPane tabbedPane = new JTabbedPane(); //панель с двумя вкладками
	private JTextPane htmlTextPane = new JTextPane(); //компонент для визуального редактирования html
	private JEditorPane plainTextPane = new JEditorPane(); //компонент для редактирования html в виде текста

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void init() { //инициализация представления
		initGui();
		this.addWindowListener(new FrameListener(this)); //для текущего окна зарегистрируем слушателя
		this.setVisible(true); // покажем окно
	}

	public void exit() {
		controller.exit();
	}

	public void initMenuBar() { //инициализация меню

	}

	public void initEditor() { //инициализация панелей редактора

	}

	public void initGui() { //инициализация графического интерфейса
		initMenuBar();
		initEditor();
		pack(); // установка минимального размера контейнера, который достаточен для отображения всех компонентов
	}

	public void selectedTabChanged() {

	}

}
