import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellChecker {
	
	  Set<String> words_perfect;
      Map<String , String> words_cap;
      Map<String, String> words_vow;
  public String[] spellchecker(String[] wordlist, String[] queries) {
      
     words_perfect = new HashSet(); //just keeping words from wordList "Kite"
      words_cap = new HashMap(); //converting the word to lowercase and lowercase as key and actual word as value for eg; "kite -> Kite"
      words_vow = new HashMap(); // take teh lowercase word and replace a, e i, o ,u characters with * and remaining with whatever chars it is
                                 //for eg Kite key is "k*t* -> Kite"

      for(String word : wordlist){
          
          words_perfect.add(word);
          
          String wordlow = word.toLowerCase();
          words_cap.putIfAbsent(wordlow , word);
          
          String wordlowDV = devowel(wordlow);
          words_vow.putIfAbsent(wordlowDV , word);
          
          
      }
      
      String[] ans = new String[queries.length];
      
      for(int i=0 ; i<queries.length; i++){
          
          ans[i] = getMatching(queries[i]);
      }
      
      return ans;
      
  }
  
  
  public String getMatching(String query){
      
      if(words_perfect.contains(query))
          return query;
      
      String queryL = query.toLowerCase();
      
      if(words_cap.containsKey(queryL))
          return words_cap.get(queryL);
      
      String queryLV = devowel(queryL);
         if(words_vow.containsKey(queryLV))
          return words_vow.get(queryLV);
      
      return "";
  }
  
  
  public String devowel(String word){
      StringBuilder ans = new StringBuilder();
      
      for(char c : word.toCharArray())
          ans.append(isVowel(c) ? '*' : c);
      
      return ans.toString();
      
  }
  
  public boolean isVowel(char c){
      
      return (c == 'a' || c == 'e'  || c == 'i' || c == 'o' || c == 'u');
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
