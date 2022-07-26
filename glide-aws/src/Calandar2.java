import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Calandar2 {
	
	 TreeMap<Integer , Integer> booked;
	    public Calandar2() {
	        booked = new TreeMap<>();
	    }
	    
	    public List<String> getBookings(int[][] cals){
	    	
	    	List<String> result = new ArrayList<>();
	    	
	    	for(int[] cal : cals) {
	    		result.add(book(cal[0] , cal[1])+"");
	    	}
	    	return result;
	    }
	    
	    public boolean book(int start, int end) {
	         System.out.println("start is="+start);
	         System.out.println("end is="+end);
	        booked.put(start, booked.getOrDefault(start,0)+1);
	        booked.put(end , booked.getOrDefault(end,0)-1);
	        System.out.println("value in map for "+ start+"="+booked.get(start));
	        System.out.println("value in map for "+end+"="+booked.get(end));
	        
	        int activeEvents=0;
	        
	        for(int freq : booked.values()){
	             activeEvents+=freq;
	            if(activeEvents >= 3){
	                booked.put(start , booked.get(start)-1);
	                booked.put(end , booked.get(end)+1);
	                return false;
	            }
	        }
	        return true;
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[][] mycal = {{10,20} , {50,60} , {10,40} ,  {5,15} , {5,10} , {25,55} };
Calandar2 cal = new Calandar2();

List<String> list = cal.getBookings(mycal);

for(String cals : list)
System.out.println(cals);
	}

}
