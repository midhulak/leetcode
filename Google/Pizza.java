package Google;

public class Pizza {
	public static int closestPrice(int pizzas[], int pizzas_numbers, int toppings[], int toppings_number, int target) {
	    //Assumption: pizzas[] and toppings[] are sorted
	    if(pizzas_numbers == 0) {
	        System.out.println("closestPrice()");
	        return -1; 
	    }
	    
	    int closest_price = pizzas[0];
	    int ind = 0;
	    int low = 0;
	    int high = 0;
	    int curr_sum = 0;
	    
	    for(int i = 0; i < pizzas_numbers; i++) {
	        ind = 0;
	        curr_sum = pizzas[i];
	        do {
	            
	            if((Math.abs(closest_price-target) > Math.abs(curr_sum-target)) || (Math.abs(closest_price-target) == Math.abs(curr_sum-target) && curr_sum < closest_price)) {
	                    closest_price = curr_sum; 
	            }
	            curr_sum = pizzas[i] + toppings[ind];
	            ind++;
	        } while(ind < toppings_number);
	        
	        low = 0;
	        high = toppings_number - 1;
	        while(low < high) {
	            curr_sum = pizzas[i] + toppings[low] + toppings[high];
	            
	            if(curr_sum > target)
	                low++;
	            else if(curr_sum < target)
	                high--;
	            else
	                return target;
	                
	            if((Math.abs(closest_price-target) > Math.abs(curr_sum-target)) || (Math.abs(closest_price-target) == Math.abs(curr_sum-target) && curr_sum < closest_price))
	                closest_price = curr_sum;
	        }
	    }
	    
	    return closest_price;
	}

	  public static void main(String[] args) {
	    	int[] pizza = {800, 850, 900};
	    	int[] toppings = {50, 100, 150};
	    	int price = 1000;
	    	int[]pizza1 = {1};
	    	int[]toppings1 = {1,2};
	    	int price1 = 10;
	    	System.out.println(closestPrice(pizza, 3, toppings, 3, price));
	    	System.out.println(closestPrice(pizza1, 1, toppings1, 2, price1));
		}
}
