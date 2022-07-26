import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BuddyStrings {
	
	/**
	 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

 

Example 1:

Input: A = "ab", B = "ba"
Output: true
Example 2:

Input: A = "ab", B = "ab"
Output: false
Example 3:

Input: A = "aa", B = "aa"
Output: true
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
	 * @param A
	 * @param B
	 * @return
	 */
	
	 public boolean buddyStrings(String A, String B) {
	        
	        if(A.length() != B.length())
	            return false;
	        
	        if(A.equals(B)){
	            HashSet<Character> unique_chars = new HashSet();
	            for(char c : A.toCharArray()){
	                unique_chars.add(c);
	            }
	            
	            if(unique_chars.size() < A.length())
	                return true;
	            else
	                return false;
	        }
	        
	        List<Integer> diff = new ArrayList();
	        
	        for(int i=0 ; i < A.length(); i++){
	            
	            if(A.charAt(i) != B.charAt(i))
	                diff.add(i);
	        }
	        
	        
	        if(diff.size() == 2 && A.charAt(diff.get(0)) == B.charAt(diff.get(1)) &&
	          B.charAt(diff.get(0)) == A.charAt(diff.get(1)))
	           
	            return true;
	        
	        else
	            return false;
	            
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
