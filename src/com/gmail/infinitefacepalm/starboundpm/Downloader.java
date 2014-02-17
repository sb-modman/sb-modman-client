package com.gmail.infinitefacepalm.starboundpm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader implements Runnable {

	public URL url;
	
	public Downloader(URL url) {
		this.url = url;
	}
	
	public void download() {
		try {
			ReadableByteChannel rbc = Channels.newChannel(url.openStream());
			FileOutputStream fos = new FileOutputStream("D:\\Steam\\steamapps\\common\\Starbound\\mods");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		download();
	}
	
}
