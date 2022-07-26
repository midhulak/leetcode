import java.util.Arrays;
import java.util.Comparator;


/**
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * @author midhula.kadiyala
 *
 */
public class ReorderLogFiles {
	
	public static  String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<String>() {
			
			public  int compare(String log1 , String log2) {
				
				String[] split1 = log1.split(" ", 2);  //dig1 , 8 1 5 1
				String[] split2 = log2.split(" ", 2);  // let1 , art can
				
				boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
				boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
				
				if(!isDigit1 && !isDigit2) {
					
					int result = split1[1].compareTo(split2[1]);
					
					if(result == 0)
						result = split1[0].compareTo(split2[0]);
					
					return result;
				}
				
				if(isDigit1 && isDigit2)
					return 0;
				
				if(isDigit1 && !isDigit2)
					return 1;
				
				return -1;
				
			}
		};
		
		Arrays.sort(logs , comparator);
		return logs;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] logs = { "dig1 8 1 5 1" ,"let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		reorderLogFiles(logs);
		
	}

}
