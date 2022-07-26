package com.snc.pluginChanges;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTwelve {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		byte[] data = null;
		FileInputStream stream = null;
		File file = new File("/Users/midhula.kadiyala/Documents/textFile.txt");
		try {
		stream = new FileInputStream(file);
		data = stream.readAllBytes();
		}
		catch(java.io.IOException ignored) {
			
		}
		finally {
			
				stream.close();
			
		}
		

	}

}
