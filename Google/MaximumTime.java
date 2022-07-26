package Google;
//time and space - O(1)
public class MaximumTime {
	public static void giveMeMaxTime(String tim){
	     char[] timChar = tim.toCharArray();

	    if(timChar[0] == '?') {
	    	if(timChar[1] == '3' || timChar[1] == '?') {
	    		timChar[0] = '2';
	    	} else {
	    		timChar[0] = '1';
	    	}
	        //timChar[0] = (timChar[1] <= '3' || timChar[1] == '?') ? '2' : '1';
	    }

	    if(timChar[1] == '?') {
	    	if(timChar[0] == '2') {
	    		timChar[1] = '3';
	    	} else {
	    		timChar[1] = '9';
	    	}
	    }
	        //timChar[1] = (timChar[0] == '2') ? '3' : '9';
	    if(timChar[3] == '?') {
	    	timChar[3] = '5';
	    }
	    if(timChar[4] == '?') {
	    	timChar[4] = '9';
	    }

//	    timChar[3] = (timChar[3] == '?') ? '5' : timChar[3];
//	    timChar[4] = (timChar[4] == '?') ? '9' : timChar[4];

	    System.out.println(timChar);

	}


	public static void main(String[] args) {
	    giveMeMaxTime("23:5?");// 23:59
	    giveMeMaxTime("2?:22");// 23:22
	    giveMeMaxTime("0?:??");// 09:59
	    giveMeMaxTime("1?:??");// 19:59
	}
}
