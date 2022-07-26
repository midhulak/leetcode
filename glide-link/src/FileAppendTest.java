import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppendTest {
	
	 
	    public static void main(String args[]) throws FileNotFoundException, IOException {
	        //name of File on which text will be appended,
	        //currently file contains only one line
	        //as "This data is before any text appended into file."
	        String path = "/Users/midhula.kadiyala/Documents/linkedin/sample.txt";      
	     
	        //creating file object from given path
	        File file = new File(path);
	        if(!file.exists())
	        	
	        file.createNewFile();
	     
	        //FileWriter second argument is for append if its true than FileWritter will
	        //write bytes at the end of File (append) rather than beginning of file
	        FileWriter fileWriter = new FileWriter(file,true);
	     
	        //Use BufferedWriter instead of FileWriter for better performance
	        BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);
	        fileWriter.append("This text should be appended in File form Java Program");
	     
	        //Don't forget to close Streams or Reader to free FileDescriptor associated with it
	        bufferFileWriter.close();
	     
	        System.out.println("Java Program for appending content into File has been completed");
	         
	    }
	 
	}


	


