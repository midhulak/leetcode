package Google;
import java.util.*;
public class FindStartIndexOfPermutations {
public static List<Integer> findAnagrams(String s, String t) {
        
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int start = 0;
        int end = 0;
        // counter stores the count of unique words present in t
        int count = map.size();

        while(end < s.length()) {
            if(map.containsKey(s.charAt(end))) {
                // decrease the count when same character is fond in s
                map.put(s.charAt(end), map.get(s.charAt(end)) -1);
                // if that particular character is exhausted then decrease the count of the unique words
                if(map.get(s.charAt(end)) == 0) {
                    count--;
                }
            }
            end++;
            //if all of our unique characters are exhausted
            while(count == 0) {
                //get the starting character and restore the hashmap count
                if(map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start))  + 1);
                    if(map.get(s.charAt(start)) > 0) {
                        // as sound as the a particular unique character freqency  is greater than 0 increase our counter
                    	// it wount be incresed twic for the same character beacause as soon as counter>0 we are out ofthe loop
                        count++;
                    }
                }
                // if our end index - starting innex is exactly equal to our t   length we found our anagram
                if(end - start == t.length()) {
                    list.add(start);
                }
                start++;
            }
        }
        return list;
    }
public static void main(String[]args) {
	String s = "abcdaedbca";
	String t = "abcd";
	System.out.println(findAnagrams(s, t));
}
}
