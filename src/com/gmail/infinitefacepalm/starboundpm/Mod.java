package com.gmail.infinitefacepalm.starboundpm;

import java.net.URL;

public class Mod {

	private String name;
	private String description;
	private URL downloadLink;
	
	public Mod(String name, String description, URL downloadLink) {
		this.name = name;
		this.description = description;
		this.downloadLink = downloadLink;
	}
	
}
