package com.snc.phone.searching.sorting;

public class IntersectionOfArarysDuplicates {
	
	/**
    Time Complexity: \mathcal{O}(n + m)O(n+m), where nn and mm are the lengths of the arrays. We iterate through the first, and then through the second array; insert and lookup operations in the hash map take a constant time.

Space Complexity: \mathcal{O}(\min(n, m))O(min(n,m)). We use hash map to store numbers (and their counts) from the smaller array.
**/
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer , Integer> map = new HashMap<>();
        
        for(int n1 : nums1){
            
            map.put(n1 , map.getOrDefault(n1 ,0)+1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int n2 : nums2){
            
            if(map.containsKey(n2)){
                list.add(n2);
                map.put(n2 , map.get(n2) - 1);
                
                if(map.get(n2) == 0 )
                map.remove(n2);
            }
            
            
        }
        
        int[] result = new int[list.size()];
        
       for(int i=0; i<list.size(); i++){
           result[i] = list.get(i);
       }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
