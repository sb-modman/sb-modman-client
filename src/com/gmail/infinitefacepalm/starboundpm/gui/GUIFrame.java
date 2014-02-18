package com.gmail.infinitefacepalm.starboundpm.gui;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class GUIFrame extends JFrame implements ListSelectionListener {
	
	private static final long serialVersionUID = 1L;
	private DefaultListModel listModel = new DefaultListModel();
	
	public GUIFrame(String[] modnames) {
		super("Sphereconstrained Package Manager");
		for (String s : modnames)
			listModel.addElement(s);
		
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("442px"),},
			new RowSpec[] {
				RowSpec.decode("270px"),})
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JList list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		scrollPane.setViewportView(list);
		getContentPane().add(scrollPane, "1, 1, fill, fill");
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// maybe display extended mod info on the side?
	}
	
}