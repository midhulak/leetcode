
public class BuyAndSellStock {
	
	  public int maxProfit(int[] prices) {
	         int minprice = Integer.MAX_VALUE;
		        int maxprofit = 0;
		        for (int i = 0; i < prices.length; i++) {
		            if (prices[i] < minprice)
		                minprice = prices[i];
		            else if (prices[i] - minprice > maxprofit)
		                maxprofit = prices[i] - minprice;
		        }
		        return maxprofit;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
