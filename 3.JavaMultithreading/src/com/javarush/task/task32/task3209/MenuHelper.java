package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Taly on 15.01.2018.
 */
public class MenuHelper {
	public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
		JMenuItem jMenuItemText = new JMenuItem(text); // Создать новый пункт меню JMenuItem, используя text.
		jMenuItemText.addActionListener(actionListener); //Установить этому пункту слушателя действий с помощью метода addActionListener().
		parent.add(jMenuItemText); //Добавляем в parent созданный пункт меню.
		return jMenuItemText; //Возвращаем созданный пункт меню.
	}

	public static JMenuItem addMenuItem(JMenu parent, Action action) {
		JMenuItem jMenuItemAction = new JMenuItem(action);
		parent.add(jMenuItemAction);
		return jMenuItemAction;
	}

	public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
		JMenuItem jMenuItemText = addMenuItem(parent, action);
		jMenuItemText.setText(text);
		return jMenuItemText;
	}

	public static void initHelpMenu(View view, JMenuBar menuBar) {

	}

	public static void initFontMenu(View view, JMenuBar menuBar) {

	}

	public static void initColorMenu(View view, JMenuBar menuBar) {

	}

	public static void initAlignMenu(View view, JMenuBar menuBar) {

	}

	public static void initStyleMenu(View view, JMenuBar menuBar) {

	}

	public static void initEditMenu(View view, JMenuBar menuBar) {

	}

	public static void initFileMenu(View view, JMenuBar menuBar) {

	}


}
