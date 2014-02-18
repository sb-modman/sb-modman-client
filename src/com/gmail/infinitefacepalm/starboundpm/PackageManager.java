package com.gmail.infinitefacepalm.starboundpm;

import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.gmail.infinitefacepalm.starboundpm.gui.GUIFrame;

public class PackageManager {

	public static File downloadLocation;
	
	public static void main(String[] args) {
		GUIFrame frame = new GUIFrame(new String[]{"Starbound Mod", "Overpowered Mod"});
		// As an aside, I can't believe this isn't already in the JFrame constructor by now. 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setVisible(true);
	}
	
}
