import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AirBNB {
	
	private static int getMinCandy(List<Integer> candyPiles , int hours){
	    Collections.sort(candyPiles);

	        int low=0, high=candyPiles.get(candyPiles.size()-1);
	        while (low<high){
	            int mid= (low+high)/2, count=0;
	            for (Integer candy: candyPiles) {
	                count+=Math.ceil((double)candy/mid);
	            }
	            if (count>hours) 
	            low=mid+1;  // increase eating candy count
	            else high=mid;  //decreasing eating candy count per hour
	        }
	        return low;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("--->"+Math.ceil((double)4/5));
		List<Integer> candies = new ArrayList<>();
		
		candies.add(4);
		candies.add(9);
		candies.add(11);
		candies.add(17);
		
		getMinCandy(candies , 8);
	}

}
