import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	     public static  List<String> wordBreak(String s, List<String> wordDict) {
	    	 
	    	 Set<String> dict = new HashSet<>();
	    	 
	    	 for(int i=0 ; i<wordDict.size(); i++) {
	    		 dict.add(wordDict.get(i));
	    	 }
	    	 
	        List<String> results = new LinkedList<String>();
			wordBreak(new ArrayList<String>(), s, dict, results);
			return results;
			}
	 
	 
			private static void wordBreak(List<String> curr, String remainder, Set<String> dict, List<String> results) {
			if (remainder.length() == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < curr.size() - 1; i++) {
			sb.append(curr.get(i) + " ");
			}
			sb.append(curr.get(curr.size() - 1));
			results.add(sb.toString());
			return;
			}
			for (int i = 1; i <= remainder.length(); i++) {
			String substr = remainder.substring(0, i);
			if (dict.contains(substr)) {
			curr.add(substr);
			wordBreak(curr, remainder.substring(i, remainder.length()), dict, results);
			curr.remove(curr.size() - 1);
			}
			}
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s = "pineapplepenapple";
	     
	     List<String> dict = new ArrayList<String>();
	     dict.add("apple");
	     dict.add("pine");
	     dict.add("pineapple");
	     dict.add("applepen");
	     dict.add("pen");
	     
	 List<String> res=    wordBreak(s,dict);
	 
	 for(int i=0 ; i<res.size(); i++) {
		 System.out.println("res are="+res.get(i));
	 }
	}

}
