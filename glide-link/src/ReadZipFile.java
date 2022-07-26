import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadZipFile {
	
	private static void readUsingZipInputStream() throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("")); 
		final ZipInputStream is = new ZipInputStream(bis); 
		try { 
			ZipEntry entry;
			while ((entry = is.getNextEntry()) != null) {
				System.out.printf("File: %s Size %d Modified on %TD %n", entry.getName(), entry.getSize(), new Date(entry.getTime()));
				extractEntry(entry, is); 
				} 
			} finally {
				is.close();
				} 
		}
	
	private static void extractEntry(ZipEntry entry , InputStream is) throws IOException{
		String extractedFile = entry.getName();
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(extractedFile);
			final byte[] buf = new byte[800];
			int read = 0;
			int length;
			while((length = is.read(buf , 0 , buf.length)) >= 0){
				fos.write(buf , 0 , length);
			}
		}
		catch(IOException ioex) {
			fos.close();
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
