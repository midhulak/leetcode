package com.snc.okta;

public class LavenstienDistance {
	
	
	int minEditDist(char[] s1, char[] s2, int i, int j) 

	{ 

	if(i >= s1.length && j >= s2.length){ return 0; } 

	if(i >= s1.length) 

	return s2.length - j; 

	 

	if(j >= s2.length) 

	return s1.length - i; 

	 	 

	if(s1[i] == s2[j]) 

	return minEditDist(s1, s2, i+1, j+1); 

	 

	int x = minEditDist(s1, s2, i, j+1) + 1; // INSERT 

	int y = minEditDist(s1, s2, i+1, j) + 1; // DELETE 

	int z = minEditDist(s1, s2, i+1, j+1) + 1; // UPDATE 

	 

	return getMin(x, y, z); 

	} 

	
	
	//dp Edit distance
	
	public static int lavensteindistance(String str1 , String str2) {
		
		int[][] edits = new int[str2.length()+1][str1.length()+1];
		
		for(int i=0 ; i<str2.length()+1; i++) {
			for(int j=0; j < str1.length()+1; j++) {
				
				edits[i][j] = j;
			}
			edits[i][0] = i;
		}
		
		
		for(int i=1; i<str2.length() +1; i++) {
			for(int j=1; j<str1.length()+1; j++) {
				
				if(str2.charAt(i - 1) == str1.charAt(j-1)) {
					edits[i][j] = edits[i-1][j-1];
				}
				else {
					edits[i][j] = 1 + Math.min(edits[i-1][j-1], Math.min(edits[i - 1][j], edits[i][j-1]));
				}
			}
		}
		
		return edits[str2.length()][str1.length()];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
