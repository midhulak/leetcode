import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {

	
	public static  void readFile() {
		try {
	FileReader largeFile = new FileReader("/Users/midhula.kadiyala/Documents/nonflapper.txt");
	char[] buffer = new char[8000];
	
int reader = largeFile.read(buffer);

if(reader != -1) {
	
	System.out.print((char)reader);
	reader = largeFile.read(buffer);
}
	
largeFile.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
	
		readFile();
	}
}
