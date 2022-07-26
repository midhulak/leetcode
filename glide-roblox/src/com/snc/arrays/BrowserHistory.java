package com.snc.arrays;


/*https://leetcode.com/problems/design-browser-history/submissions/*/

//ou have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
//
//Implement the BrowserHistory class:
//
//BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
//void visit(string url) Visits url from the current page. It clears up all the forward history.
//string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
//string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
// 
//
//Example:
//
//Input:
//["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
//[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
//Output:
//[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

public class BrowserHistory {
	
	String[] history = new String[50001];
    int curr,end;

    public BrowserHistory(String homepage) {
        
        history[0] = homepage;
        curr =0 ;
        end = 0;
    }
    
    public void visit(String url) {
       if( history[curr] != url){
           curr++;
           history[curr] = url;
           end=curr;
       }
      
    }
    
    public String back(int steps) {
        //getting max if going back it should not be minus
        curr = Math.max(0 , curr-steps);
        return history[curr];
    }
    
    public String forward(int steps) {
    	//getting min if forward number is not greater than the links we have visited so far.
        curr = Math.min(end , curr+steps);
        return history[curr];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
