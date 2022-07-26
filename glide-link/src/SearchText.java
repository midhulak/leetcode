import java.io.File;
import java.util.Scanner;

public class SearchText {

	private static Scanner x;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	/Users/midhula.kadiyala/Documents/textFile.txt
		
		String filePath = "/Users/midhula.kadiyala/Documents/textFile.txt";
		String searchTerm = "8053";
		readRecord(searchTerm , filePath);
		
	}
	
	public static void readRecord(String searchTerm , String filePath) {
		
		boolean found = false;
		String ID = "";
		String name = "";
		String age = "";
		
		try {
//			x = new Scanner(new File(filePath));
//			String line = x.nextLine();
//			
//			while(line != null && !found) {
//				String[] attr = line.split(",");
//				
//				if(attr[0].equals(searchTerm)) {
//					System.out.println("found id");
//					found=true;
//				}
//				
//				line=x.nextLine();
//			}
			
			x = new Scanner(new File(filePath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext() && !found) {
				ID = x.next();
				name = x.next();
				age = x.next();
				
				if(ID.equals(searchTerm)) {
					found = true;
					System.out.println("found it");
				}
			}
			
		}
		catch(Exception e) {
			
		}
	}

}
