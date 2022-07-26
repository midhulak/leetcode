package com.ik;

public class FirstNonRepeating {

	static final int NO_OF_CHARS = 26;
    static int  count[][] = new int[26][2];
   // ABBAGFCDC
    /* calculate count of characters
       in the passed string */
    static void getCharCountArray(String str)
    {
        for (int i = 0; i < str.length(); i++) {
        	int pos = str.charAt(i);
        	//System.out.println( str.charAt(i));
            count[str.charAt(i) - 'A'][0]++; 
            count[str.charAt(i) - 'A'][1] = i;
           // System.out.println(count[str.charAt(i)]);
        }
    }
 
    /* The method returns index of first non-repeating
       character in a string. If all characters are repeating
       then returns -1 */
    static int firstNonRepeating(String str)
    {
        getCharCountArray(str);
       // int index = -1;
        int min = Integer.MAX_VALUE;
 
        for (int i = 0; i < count.length; i++) {
        	
        	if(count[i][0] == 1) {
        		
        		if(min > count[i][1]) {
        			min=count[i][1];
        			//index=count[i][0];
        		}
        		
        	}
            
        }
 
        return min == Integer.MAX_VALUE ? -1 : min;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABBAGFGCDC";
        int index = firstNonRepeating(str);
           System.out.println(index);

	}

}
