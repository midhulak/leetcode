package com.snc.trees.graphs;

public class Demo {
	
	
	public void getMessage() {
		System.out.println("printing messages");
	}
	
	
	public void  callRecursive() {
		int count=10;
		int i=0;
		dfs(count , i);
	}
	
	
	public void dfs(int count , int i) {
		if(i == count)
			return;
	
		getMessage();
		dfs(count , i+1);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Demo d = new Demo();
       d.callRecursive();
	}

}
