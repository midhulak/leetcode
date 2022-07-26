import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFileToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
		InputStream is = new FileInputStream("/Users/midhula.kadiyala/Documents/nonflapper.txt");
		BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		
		String line = buf.readLine();
		StringBuilder sb = new StringBuilder();
		
		while(line != null) {
			sb.append(line);
			//System.out.println(line);
			line = buf.readLine();
			
		}
		System.out.println(sb.toString());
		is.close();
		buf.close();
	}
catch(IOException e) {
	e.printStackTrace();
}

}
}
