import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvantageShuffle {
	
	  public static int[] advantageCount(int[] A, int[] B) {
	        
	        Map<Integer , Integer> map = new HashMap<>();
	        
	        for(int i=0 ; i<B.length; i++){
	            map.put(B[i] , i);
	        }
	        Arrays.sort(A);
	        Arrays.sort(B);
	        
	        List<Integer> unUsed = new ArrayList<Integer>();
	        
	        int[] result = new int[B.length];
	        
	        int i=0;
	        int j=0;
	       while(j < B.length){
	           
	           if(i == A.length-1)
	               break;
	           
	            if(i< A.length && A[i] < B[j]){
	                unUsed.add(A[i]);
	               
	                i++;
	            }
	            System.out.println(B[j]);
	          if(map.get(B[j]) != null);
	                result[map.get(B[j])] = A[i];
	            
	            j++;
	        }
	        int unUsedCount=0;
	        while(j < B.length && unUsedCount < unUsed.size()){
	            result[map.get(B[j])] = unUsed.get(unUsedCount);
	       }
	        
	        return B;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {2,7,11,15};
		int[] B = {1,10,4,11};
		
		advantageCount(A , B);
		

	}

}
