package com.gmail.infinitefacepalm.starboundpm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader {

	public void download(URL url) {
		try {
			ReadableByteChannel rbc = Channels.newChannel(url.openStream());
			FileOutputStream fos = new FileOutputStream("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
