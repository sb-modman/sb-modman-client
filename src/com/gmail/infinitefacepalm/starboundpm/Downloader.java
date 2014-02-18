package com.gmail.infinitefacepalm.starboundpm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Downloader implements Runnable {

	private URL url;
	
	public Downloader(URL url) {
		this.url = url;
	}
	
	private void download() {
		try {
			ReadableByteChannel rbc = Channels.newChannel(url.openStream());
			// TODO: implement folder selection, this is merely for testing
			FileOutputStream fos = new FileOutputStream("D:\\Steam\\steamapps\\common\\Starbound\\mods" + File.separator + url.getFile());
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			
			ZipInputStream zis = new ZipInputStream(new FileInputStream(url.getFile()));
			ZipEntry ze = zis.getNextEntry();
			byte[] buffer = new byte[1024];
			
			fos.close();
			
			while (ze != null) {
				File newFile = new File(PackageManager.downloadLocation + File.separator + ze.getName());
				new File(newFile.getParent()).mkdirs();
				fos = new FileOutputStream(newFile);
				
				int length;
				while((length = zis.read(buffer)) != -1) {
					fos.write(buffer, 0, length);
				}
				
				fos.close();
				ze = zis.getNextEntry();
			}
			
			zis.closeEntry();
			zis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// multithreading; so next-gen
	@Override
	public void run() {
		download();
	}

	public URL getURL() {
		return url;
	}

	public void setURL(URL url) {
		this.url = url;
	}
	
}
