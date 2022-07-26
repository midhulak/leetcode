import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopKFrequent {

	  public List<String> topKFrequent(String[] words, int k) {
		     //adding it to map by countng the frequncy of each word.   
		     Map<String , Integer> map = new HashMap<String , Integer>();
		       // Set<String> set = new HashSet<>();
		        //create a bucket of size to word length and each bucket shud be an arrayList...if two words have same frequency...
		         List<String>[] bucket = new List[words.length + 1];
		        
		        for(int i=0 ; i<words.length; i++){
		            
		            map.put(words[i] , map.getOrDefault(words[i], 0) + 1);
		            
		        }
		        
		        for(String key : map.keySet()){
		            int frequency = map.get(key);
		            
		            if(bucket[frequency] == null) {
		            	bucket[frequency] = new ArrayList<>();
		            }
		            
		            bucket[frequency].add(key);
		            
		        }
		        
		       
		        List<String> list = new ArrayList<>();
		        int count = 0;
		        //then iterate it from back and return it and stop if it equals to k
		        
		        for(int i=bucket.length-1; i>=0; i--) {
		        	
		        	if(bucket[i] != null) {
		                Collections.sort(bucket[i]);
		        		for(int j=0 ; j<bucket[i].size(); j++) {
		                    if(list.size() != k)
		        			list.add(bucket[i].get(j));
		        					
		        		}
		        	}
		        }
		       // Collections.sort(list);
				return list;
		    }   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
