
public class LongestCommonSubString {
	
	 public static int longestCommonSubString(String text1, String text2) {
	        
	        int m = text1.length();
	        int n = text2.length();
	        int lcs=0;
	        
	    int dp[][] = new int[m+1][n+1];
	        
	        for(int i=1 ; i<=m; i++){
	            for(int j=1; j<=n; j++){
	                
	            if(text1.charAt(i-1) == text2.charAt(j-1)) {
	                    dp[i][j] = 1+ dp[i-1][j-1];
	                    lcs=Math.max(lcs, dp[i][j]);
	            }
	                else
	                dp[i][j] = 0;
	            }
	            
	        }
	      
	        return lcs;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String text1 = "ABC";
String text2 = "AB";
System.out.println(longestCommonSubString(text1 , text2));

	}

}
