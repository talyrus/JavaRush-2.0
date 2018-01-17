package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by Taly on 16.01.2018.
 * отвечает за стиль  "Подстрочный знак"
 */
public class SubscriptAction extends StyledEditorKit.StyledTextAction {

	public SubscriptAction() {
		super(StyleConstants.Subscript.toString());
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JEditorPane editor = getEditor(actionEvent);
		if (editor != null) {
			MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
			SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
			StyleConstants.setSubscript(simpleAttributeSet, !StyleConstants.isSubscript(mutableAttributeSet));
			setCharacterAttributes(editor, simpleAttributeSet, false);
		}
	}
}
