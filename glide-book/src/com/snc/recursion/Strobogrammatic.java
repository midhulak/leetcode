package com.snc.recursion;
import java.util.List;
import java.util.ArrayList;

public class Strobogrammatic {
	
	private final char[][] mapping = {{'0' , '0'} , {'1' ,'1'} , {'6'
 ,'9'} , {'8' , '8'} , {'9' , '6'} };	
	public List<String> findStrobogrammatic(int n){
		List<String>  res = new ArrayList<>();
		
		if(n < 1)
			return res;
		char[] chs = new char[n];
		
		helper(chs , 0 , n-1 , res);
		
		return res;
	}
	
	private void helper(char[] chs , int lo , int hi , List<String> res) {
		if(lo > hi) {
			if(chs.length == 1 || chs[0] != '0') {
				res.add(String.valueOf(chs));
			}
			return;
		}
		
		for(char[] map : mapping) {
			if(lo == hi && map[0] != map[1])
				continue;
			
			chs[lo] = map[0];
			chs[hi] = map[1];
			helper(chs , lo+1 , hi-1 , res);
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strobogrammatic s= new Strobogrammatic();
		List<String> list = s.findStrobogrammatic(3);
		
		for(String st : list) {
			System.out.println(st);
		}

	}

}
