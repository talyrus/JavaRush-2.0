package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
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
		JMenuBar jMenuBar = new JMenuBar();
		MenuHelper menuHelper = new MenuHelper();
		menuHelper.initFileMenu(this, jMenuBar);
		menuHelper.initEditMenu(this, jMenuBar);
		menuHelper.initStyleMenu(this, jMenuBar);
		menuHelper.initAlignMenu(this, jMenuBar);
		menuHelper.initColorMenu(this, jMenuBar);
		menuHelper.initFontMenu(this, jMenuBar);
		menuHelper.initHelpMenu(this, jMenuBar);
		this.getContentPane().add(jMenuBar, BorderLayout.NORTH);
	}

	public void initEditor() { //инициализация панелей редактора
		htmlTextPane.setContentType("text/html"); // Устанавили значение "text/html" в качестве типа контента для компонента htmlTextPane.
		JScrollPane jScrollPaneHtml = new JScrollPane(htmlTextPane); //Создали новый локальный компонент JScrollPane на базе htmlTextPane.
		tabbedPane.addTab("HTML", jScrollPaneHtml); //добавили его во вкладку в панель tabbedPane с именем "HTML"

		JScrollPane jScrollPaneText = new JScrollPane(plainTextPane); //Создали новый локальный компонент JScrollPane на базе plainTextPane.
		tabbedPane.addTab("Текст", jScrollPaneText); //Добавили еще одну вкладку в tabbedPane с именем "Текст" и вторым компонентом

		tabbedPane.setPreferredSize(new Dimension(1024, 768));// Устанавили предпочтительный размер панели tabbedPane.
		//Создали объект класса TabbedPaneChangeListener
		TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
		// и установили его в качестве слушателя изменений в tabbedPane.
		tabbedPane.addChangeListener(tabbedPaneChangeListener);
		// Добавили по центру панели контента текущего фрейма нашу панель с вкладками.
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
	}

	public void initGui() { //инициализация графического интерфейса
		initMenuBar();
		initEditor();
		pack(); // установка минимального размера контейнера, который достаточен для отображения всех компонентов
	}

	public void selectedTabChanged() {

	}

	public View() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public boolean canUndo() {
		return false;
	}

	public boolean canRedo() {
		return false;
	}

}
