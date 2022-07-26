package com.snc.avenCodingChallenge;
import java.util.Random;
import java.util.HashMap;
import java.io.*;

import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;
public class BloomFilterOne {
	
	static class BloomObj{
		static String[] searchStrs;
		static int bagsCount;
		static int strInEachBag;
		static File pathToStoreAllBags;
		static int howManyStringsToSearch;
	}
	
	
	static char ch[] = {'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' , 'h' , 'i' , 'j' , 'k' , 'l', 'm' , 
			'n', 'o', 'p', 'q' , 'r' , 's' , 't' , 'u' , 'v' , 'w' , 'x' , 'y' , 'z'};
	static //take 5 bags and each bag has 5 strings each and find out the target string present in which bag by filtering it, the target string 
	//might present in any bag or target string might present in multiple bags , nee dto return which bag it is present.
	Random rand = new Random();
	static Map<Integer, HashSet<String>> map = new HashMap<Integer , HashSet<String>>();
	static List<Integer[]> bloomFilter = new ArrayList<Integer[]>();
	File file = new File("/Users/midhula.kadiyala/Documents/now_workspace/aven");
	static Map<String , List<Integer>> presentMap ; 
	static Map<String , List<Integer>> notPresentMap ;
	
	
	public BloomFilterOne() {
		
	}
	

	
	@BeforeClass
	public static void insertStringsInList() {
		
		BloomObj.bagsCount = 10;
		BloomObj.strInEachBag = 10;
		BloomObj.pathToStoreAllBags = new File("/Users/midhula.kadiyala/Documents/now_workspace/aven");
		BloomObj.howManyStringsToSearch = 5;
		
		
		
		presentMap = new HashMap<String , List<Integer>>();
		notPresentMap = new HashMap<String , List<Integer>>();
		for(int i=0 ; i<BloomObj.bagsCount; i++) {  // 5 bags
			
			Integer[] arr = new Integer[BloomObj.strInEachBag];
			HashSet<String> set = new HashSet<>();
			for(int j=0 ; j<BloomObj.strInEachBag ; j++) { //each bag 5 strings

				String str = generateRandomString(4,10); //generate random strings of length size min 4 and max 10.
				
				int hash1 = computeHash1(str);
				int hash2 = computeHash2(str);
				
				arr[hash1] = 1;
				arr[hash2] = 1;
				set.add(str);
				}
			
			map.put(i, set);
			bloomFilter.add(i,arr);
		}
	
		generateStringsToFile(BloomObj.strInEachBag);
		generateStringsToSearch();
		printResults();
		}
	
	private static int computeHash1(String str) {
		int hash=0;
		for(int i=0; i<str.length(); i++) {
			hash+= str.charAt(i);
		}
		return hash%BloomObj.strInEachBag;
	}
	
	
	private static int computeHash2(String str) {
		int hash=0;
		for(int i=0; i<str.length(); i++) {
			hash+= 2*str.charAt(i)+3;
		}
		return hash%BloomObj.strInEachBag;
	}
	
	
	@Test
	public void isStringsPresentInBags() {
		
		for(int i=0 ; i<BloomObj.searchStrs.length; i++) {
			
			if(presentMap.containsKey(BloomObj.searchStrs[i])) {
				
				for(Integer bag : presentMap.get(BloomObj.searchStrs[i])) {
					System.out.println("checking string present in bag "+bag);
					if(map.get(bag).contains(BloomObj.searchStrs[i]))
							assert true;
				}
			}
		}
	}
	
	@Test
	public  void isStringsNotPresentInBags() {
		
		for(int i=0 ; i<BloomObj.searchStrs.length; i++) {
			
			if(notPresentMap.containsKey(BloomObj.searchStrs[i])) {
				
				for(Integer bag : notPresentMap.get(BloomObj.searchStrs[i])) {
					System.out.println("checking string "+BloomObj.searchStrs[i]+ " not present in bag "+bag);
					if(map.get(bag) != null && map.get(bag).contains(BloomObj.searchStrs[i]))
							assert false;
				}
			}
		}
	}
	
	private static void printResults() {
		System.out.println("");
		for(int i=0 ; i<BloomObj.searchStrs.length; i++) {
			System.out.println(BloomObj.searchStrs[i]+":Present In Bags");
			if(presentMap.containsKey(BloomObj.searchStrs[i])) {
				System.out.print("[");
				for(Integer bagNum : presentMap.get(BloomObj.searchStrs[i])) {
					System.out.print(bagNum+" ");
				}
				System.out.print("]");
			}
			else 
				System.out.print("[]");
				System.out.println(" ");
			System.out.println(BloomObj.searchStrs[i]+":Not Present In Bags");
			
			
			if(notPresentMap.containsKey(BloomObj.searchStrs[i])) {
				System.out.print("[");
				for(Integer bagNum : notPresentMap.get(BloomObj.searchStrs[i])) {
					System.out.print(bagNum+" ");
				}
				System.out.print("]");
			}
			else
			System.out.print("[]");
			System.out.println(" ");
		}
		
	
		
	}
	
	private static String generateRandomString(int min , int max) {
		int lenOfEachString = rand.nextInt(max-min+1)+min;
		StringBuffer sb = new StringBuffer();
		for(int k=0 ; k<lenOfEachString; k++) {  // generating random characters of string length
			
			sb.append(ch[rand.nextInt(25-0+1)+0]); // constructed string
			
		}
		return sb.toString();
	}
	
	private static void generateStringsToSearch() {
		
		BloomObj.searchStrs = new String[BloomObj.howManyStringsToSearch];
		//pick half random strings of length 4 to 10 and half strings random strings from the list we have generated.
		
		int randStrInListSize =BloomObj.howManyStringsToSearch/2;
		
		for(int i=0 ; i<randStrInListSize; i++) {
			
			int bagToSelect = rand.nextInt((BloomObj.bagsCount-1)-0+1)+0;
			
			int randomIndexStrFromBag = rand.nextInt(BloomObj.strInEachBag - 1 + 1)+1;
			
			int count=1;
			
			HashSet<String> strs = map.get(bagToSelect);
			
			for(String str :strs) {
				
				if(count == randomIndexStrFromBag) {
					BloomObj.searchStrs[i] = str;
					break;
				}
				
				count++;
			}
		}
		
		for(int k=BloomObj.searchStrs.length-1 ; k>=randStrInListSize; k--) {
			
			BloomObj.searchStrs[k] = generateRandomString(4,10);
		}
		System.out.println("=========================");
		System.out.println("Generating mix of constructed and random strings of count "+BloomObj.howManyStringsToSearch);
		for(int i=0 ; i<BloomObj.searchStrs.length;i++) {
			
			System.out.print(BloomObj.searchStrs[i]+" ");
		}
		System.out.println(" ");
		
		for(int i=0 ; i<BloomObj.searchStrs.length; i++) {
			SearchStrUsingBloomFilter(BloomObj.searchStrs[i]);
			
		}
	}
	
	private static void SearchStrUsingBloomFilter(String str) {
		
		int hash1 = computeHash1(str);
		int hash2 = computeHash2(str);
		//int hash3 = computeHash3(s);
	
		int bag=1;
		for(Integer[] index : bloomFilter) {
			
			
			if(index[hash1] == null || index[hash2] == null  ) {
				if(notPresentMap.containsKey(str)) {
					List<Integer> list = notPresentMap.get(str);
					list.add(bag);
					notPresentMap.put(str, list);
					
				}
				else {
				List<Integer> list = new ArrayList<>();
				 list.add(bag);
				 notPresentMap.put(str, list);
				}
			}
			else {
				
				if(presentMap.containsKey(str)) {
					List<Integer> list = presentMap.get(str);
					list.add(bag);
					presentMap.put(str, list);
					
				}
				else {
				List<Integer> list = new ArrayList<>();
				 list.add(bag);
				 presentMap.put(str, list);
				}
				
				
			}
			bag++;
		}
		
		
	}
	
	private static void generateStringsToFile(int strInEachBag) {
		try {
		File f  = new File("/Users/midhula.kadiyala/Documents/now_workspace/aven/aven_bloomFilter.txt");
		
		if(!f.exists()) {
			f.createNewFile();
		}
		
		else {
			f.delete();
			f.createNewFile();
		}
		
		BufferedWriter out = new BufferedWriter(new FileWriter(f.toString() , true));
		
		
	
		for(Map.Entry<Integer, HashSet<String>> entry : map.entrySet()) {
			System.out.println(" ");
			int index = entry.getKey()+1;
			System.out.print("BAG#"+index);
				System.out.print("[");
				int i = 0;
			for(String str: entry.getValue()) {
                 if(i == strInEachBag-1)
					System.out.print(str);
                 else
                	 System.out.print(str+",");
                 i++;
			}
			System.out.print("]");
			
		}

		System.out.println(" ");
		int i=1;
		for(Map.Entry<Integer, HashSet<String>> entry : map.entrySet()) {
		
			int count=0;
			out.newLine();
			out.write("BAG#"+i+"[");
			for(String str: entry.getValue()) {
				if(count == strInEachBag-1) {
					out.write(str);
					out.write("]");
			}
				else
				out.write(str+",");
			
				
				count++;
			
	}
			i++;
		
		}
		out.close();
		}
		catch(IOException e) {
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//b.insertStringsInList(numOfBags , numOfStringsinEachBag , howmanystringsSearching , fileToStoreStringsInEachBag , FileToseewhichbagdoesnothavesearchedStirng);
		
		File f  = new File("/Users/midhula.kadiyala/Documents/now_workspace/aven/aven_bloomFilter.txt");
			insertStringsInList();

	}

}
