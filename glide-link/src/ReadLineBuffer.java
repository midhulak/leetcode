import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineBuffer {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		FileReader reader = new FileReader("/Users/midhula.kadiyala/Documents/nonflapper.txt");
		BufferedReader buffReader = new BufferedReader(reader);
		String line = buffReader.readLine();
		
		while(line != null) {
			System.out.println("reading lines->"+line);
			line = buffReader.readLine();
		}
		
		buffReader.close();
		reader.close();

	}
	catch(IOException e) {
		e.printStackTrace();
	}
	}
}
