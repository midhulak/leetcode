package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	/*in every iteration we add a word in dict to the existed strs, s[len(strs):len(strs)+len(word)]==word 
	will make the strs in bfs expand as the alphabetical order in target s. 
	As long as we find target s, we can return the value or key strs, which make up the strs*/
	
	public static List<String> getMinWords(String s, List<String> dict) {
        return getMinWordsHelper(s, dict, new HashMap<>());
    }

    private static List<String> getMinWordsHelper(String s, List<String> dict, HashMap<String, List<String>> memo) {

        if (s == null || s.length() == 0) {
        	return new ArrayList<>();
        }

        List<String> result = null;
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(0, i + 1);
            if (dict.contains(substring)) {
                List<String> restResult = getMinWordsHelper(s.substring(i + 1), dict, memo);
                if (restResult != null) {
                    restResult.add(substring);
                    if (memo.get(s) != null) {
                        if (memo.get(s).size() > restResult.size()) {
                            memo.put(s, restResult);
                            result = restResult;
                        }
                    } else {
                        memo.put(s, restResult);
                        result = restResult;
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMinWords("bedbathandbeyand", Arrays.asList("bed", "bath", "bat", "and", "hand", "bey", "beyand")).toArray()));
        List<String> result2 = getMinWords("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        if (result2 == null) {
            System.out.println("null");
        }
    }
}
