package Google;

import java.util.Arrays;

public class CountIntegerPartitions {
	public static int change(int N) {        
        int dp[]=new int[N+1];
        Arrays.fill(dp, 1);
        for(int j=2;j<=N;j++){
            for(int i=j;i<=N;i++){
                dp[i] = dp[i-j]+dp[i];
            }
        }
        return dp[N]-1;
    }
	public static void main(String[]args) {
		System.out.println(change(5));
	}
}
