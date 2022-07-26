
public class ReplaceElements {
	
	 public static int[] replaceElements(int[] arr) {
    
    // 17,18,5,4,6,1
         int max = Integer.MIN_VALUE;

     int[] result = new int[arr.length];
     result[arr.length-1] = -1;
     for(int i=arr.length-1 ; i>=1 ; i--){
         System.out.println("i value is="+i);
         max=Math.max(max, arr[i]);
         
         result[i-1] = max;
     }
     return result;
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[] arr = {17,18,5,4,6,1};
   replaceElements(arr);
   
	}

}
