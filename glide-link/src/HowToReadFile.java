import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class HowToReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ex reading file's content using FileInputStream
		try {
			
			FileInputStream fis = new FileInputStream("/Users/midhula.kadiyala/Documents/nonflapper.txt");
			int data = fis.read();
			
			while(data != -1) {
				System.out.println(">>>>>"+Integer.toHexString(data));
				data = fis.read();
			}
			
		}
		
		catch(IOException e) {
			System.out.println("Failed to read binary data from file");
			e.printStackTrace();
		}
		
		//reading file data using fileReader in java
		
		try {
			FileReader reader = new FileReader("/Users/midhula.kadiyala/Documents/nonflapper.txt");
			int character = reader.read();
			while(character != -1) {
				System.out.print((char)character);
				character = reader.read();
			}
			
		}
		
		catch(IOException io) {
			System.out.println("Failed to read charcater data from file");
			io.printStackTrace();
			
		}

	}

}
