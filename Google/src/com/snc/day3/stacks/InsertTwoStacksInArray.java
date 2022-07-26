package com.snc.day3.stacks;

public class InsertTwoStacksInArray {
	
	 int[] arr ;
	 int t1;
	 int t2;
	 int n;
	
	InsertTwoStacksInArray(int n){
		
		 arr = new int[n];
		this.t1=-1;
		this.t2=n;
		this.n=n;
		
	}
	
	public  void s1push(int val) throws Exception {
		
		if(isS1Full())
			throw new Exception();
		arr[++t1] = val;
		
	}
	
   public  void s2push(int val) throws Exception {
	   if(isS2Full())
		   throw new Exception();
	   arr[--t2] = val;
	   
	}

   public  int s1pop() throws Exception{
	
	   if(isEmptyS1())
			throw new Exception();
	   
	   return arr[t1--];
   }

   public  int s2pop() throws Exception{
	   
	   if(isEmptyS2())
			throw new Exception();
	   
	   return arr[t2++];
	
   }
	
	public  boolean isEmptyS1() {
		
		return t1 == -1;
	}
	
    public  boolean isEmptyS2() {
    	
    	return t2 == n;
		
	}
    
public  boolean isS1Full() {
		
		return t1+1 == t2;
	}
	
    public  boolean isS2Full() {
    	
    	return t1+1 == t2;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
