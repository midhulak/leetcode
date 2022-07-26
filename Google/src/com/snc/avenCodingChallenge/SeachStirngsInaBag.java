package com.snc.avenCodingChallenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Map;



/*
 * generate random strings into the file
 */

public class SeachStirngsInaBag {
	
	static int bagsCount=1000;
	static int strInEachBag=15000;
	String path ="/Users/midhula.kadiyala/Documents/now_workspace/bloom";
	 Random rand = new Random();
	 char ch[] = {'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' , 'h' , 'i' , 'j' , 'k' , 'l', 'm' , 
				'n', 'o', 'p', 'q' , 'r' , 's' , 't' , 'u' , 'v' , 'w' , 'x' , 'y' , 'z'};
	 int[][] bloomFilter = new int[1000][strInEachBag];
	 
	 
	 
	 private Map<String , List<Integer>> searchStrings(String[] strs) {
		   //generateRandomStringsInFile();
			populateStrsInBloomFilterFromFile();
			
			Map<String , List<Integer>> outMap = new HashMap<>();
			
			for(int i=0 ; i<strs.length; i++) {
			int hash1 = computeHash1(strs[i]) % strInEachBag;
			int hash2 = computeHash2(strs[i]) % strInEachBag;
 			int hash3 = computeHash3(strs[i]) % strInEachBag;
//				int hash1 = Math.abs(murmur(strs[i] , 7)) %5000;
//				int hash2 = Math.abs(murmur(strs[i] , 10)) %5000;
				//int hash1 = Math.abs(hash32(strs[i])) % 1000;
		
			List<Integer> list = new ArrayList<Integer>();
			for(int k=0; k<bloomFilter.length; k++) {
				
				if(bloomFilter[k][hash1] == 0 || bloomFilter[k][hash2] == 0 /*|| bloomFilter[k][hash3] == 0*/)
				{
						continue;
				}
				else {
					list.add(k+1);
					
				}
				
			}
			
			outMap.put(strs[i], list);
			}
			return outMap;
		}

	
public  void generateRandomStringsInFile() {
	BufferedWriter out = null;
	try { 
		File dir  = new File(path.toString());
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		File fileName = new File(path.toString()+"/randomStrings.txt");
		
		if(!fileName.exists()) {
			fileName.createNewFile();
		}
		else {
			fileName.delete();
			fileName.createNewFile();
		}
	 out = new BufferedWriter(new FileWriter(fileName.toString() , true));
		
	}
	catch(IOException ie) {
		
	}

		
		for(int i=0 ; i<bagsCount; i++) {  
		int count=1;
			for(int j=0 ; j< strInEachBag ; j++) { //each bag 5 strings

				String str = generateRandomString(4,10); //generate random strings of length size min 4 and max 10.
				
			try {
				if(count == strInEachBag)
				out.write(str);
				else
					out.write(str+",");
				
				count++;
				
				}
			catch(IOException ie) {
				
			}
			

		}
	
			try {
				out.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File Created Successfully at path");
		
		
}



public static int hash32(final String k) {
 int FNV_32_INIT = 0x811c9dc5;
 int FNV_32_PRIME = 0x01000193;
    int rv = FNV_32_INIT;
    final int len = k.length();
    for(int i = 0; i < len; i++) {
        rv ^= k.charAt(i);
        rv *= FNV_32_PRIME;
    }
    return rv;
}


	 public static int murmur(String str, int seed) {
	        if (str == null)
	            throw new IllegalArgumentException("str cannot be null");
	        final int m = 0xc6a4a793;
	        final int r = 16;
	        int hash = seed ^ (str.length() * m);
	        byte b[] = str.getBytes();
	        int len = b.length;
	        int i = 0;
	        while (len >= 4) {
	            int l = b[i] + b[i + 1] << 8 + b[i + 2] << 16 + b[i + 3] << 24;
	            hash += l;//from  w  w  w.  jav  a  2s.  c o m
	            hash *= m;
	            hash ^= hash >>> r;
	            len -= 4;
	            i += 4;
	        }
	        switch (len) {
	        case 3:
	            hash += b[i + 2] << 16;
	        case 2:
	            hash += b[i + 1] << 8;
	        case 1:
	            hash += b[i];
	            hash *= m;
	            hash ^= hash >>> r;
	        }
	        hash *= m;
	        hash ^= hash >>> 10;
	        hash *= m;
	        hash ^= hash >>> 17;
	        return hash;
	    }
	

public  int computeHash1(String str) {
	 int hash =7;
	for(int i=0; i<str.length(); i++) {
		hash=hash*31+str.charAt(i);
		
	}
	return Math.abs(hash);
}


public  int computeHash2(String str) {
	 int hash =13;
		for(int i=0; i<str.length(); i++) {
			hash=hash*31+str.charAt(i);
			
		}
		return Math.abs(hash);
}

public  int computeHash3(String str) {
	 int hash =18;
		for(int i=0; i<str.length(); i++) {
			hash=hash*31+str.charAt(i);
			
		}
		return Math.abs(hash);
}




/*
 * Read each line from file and populate those strings into boom filter by computing a hashfunction.
 */

private void populateStrsInBloomFilterFromFile() {
	
	try {
		File f = new File(path.toString()+"/randomStrings.txt");
		
		 Scanner scanner = new Scanner(f);
		 int count=0;
		
	        while (scanner.hasNextLine()) {
	        	String line =  scanner.nextLine();
	        	String[] strs = line.split(",");
	        	
					for(String s : strs) {
				int hash1 = computeHash1(s)%strInEachBag;
				int hash2 = computeHash2(s)%strInEachBag;
				int hash3 = computeHash3(s)%strInEachBag;
						//int hash1 =  Math.abs(hash32(s)) % 1000;
//					
//						int hash1 = Math.abs(murmur(s , 7)) %5000;
//    					int hash2 = Math.abs(murmur( s, 10)) %5000;
//						int hash3 = Math.abs(murmur(s , 15))%1000;
					
						
					bloomFilter[count][hash1] = 1;
					bloomFilter[count][hash2] = 1;
					bloomFilter[count][hash3] = 1;
					
		          }
					
					count++;
	        }
	        
	       
		
	}
	catch(IOException io) {
		
	}
	

	
	
}




private  String generateRandomString(int min , int max) {
	int lenOfEachString = rand.nextInt(max-min+1)+min;
	StringBuffer sb = new StringBuffer();
	for(int k=0 ; k<lenOfEachString; k++) {  // generating random characters of string length
		
		sb.append(ch[rand.nextInt(25-0+1)+0]); // constructed string
		
	}
	return sb.toString();
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeachStirngsInaBag g = new SeachStirngsInaBag();
		
		String[] str = {"midhulakadiyala" , "usman" , "Chaturya123" , "jwvmpbuxi" , "fdjgjgdfjkd" , "podmbdyhk" ,"dog"};
		Map<String , List<Integer>> outMap = g.searchStrings(str);
		System.out.println("Results");
		System.out.println("");
		for(Map.Entry<String, List<Integer>> entry : outMap.entrySet()) {
			
			System.out.println(entry.getKey()+" found in "+entry.getValue().size()+" bags");
			for(Integer bag : entry.getValue()) {
				System.out.print(bag+" ");
			}
			System.out.println(" ");
		}
	}

}
