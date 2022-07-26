package com.snc.uber.phone;


	import java.io.*;
	import java.util.Map;
	import java.util.HashMap;
	import java.util.List;
	import java.util.ArrayList;
	/*
	Question

	Given list of folders, print the path of a given folder from root. If there is no path to the root folder then return an empty string. Root level folders will have 0 as id. The structure of Folder is like this:
	class Folder {
	   int id;
	   List<int> subfolders;
	   String name;
	}


	Ex: 
	list = [Folder(0, [7, 3], “abc”), Folder(0, [], “xyz”), Folder(8, [6], “def”), Folder(7, [9,6], “ijk), Folder(9, [], “lmn”)]

	7 > abc
	3 -> abc
	6 ->def,ijk
	9->ijk,lmn


	//0 ,[][7,3] 
	printPath(9) = “abc” -> “ijk” -> “lmn” printPath(8) = ""
	Clarification: There can be multiple root level folders. All other folders have unique ids.
	Note: printPath method may be called multiple times. Design your solution taking that into account
	*/
	// Main class should be named 'Solution'
	class Solution {
	    
	    static class Folder {
	   int id;
	   List<Integer> subfolders;
	   String name;
	}
	static Map<Integer , List<Folder>> map = new HashMap<>();

	static Map<Integer , List<String>> parentMap = new HashMap<>();

	    
	    public static void printPath(List<Folder> folders){
	        
	        if(folders.size() == 0)
	          return;
	        for(Folder f : folders){
	            
	           String name = f.name;
	           List<String> lsubList = new AraryList<>();
	               lsubList.add(f.name)
	           for(Integer subIds : f.subfolders){
	               if(parentMap.containsKey(subIds)){
	                  parentMap.get(subIds).add(f.name);
	               }
	               parentMap.put(subIds ,lsubList);
	           }
	           
	            if(map.containsKey(f.id)){
	               List<Folder> list = map.get(f.id);
	               list.add(f);
	               map.put(f.id , list);
	            
	            }
	            
	            if(map.containsKey(f.id)){
	               List<Folder> list = map.get(f.id);
	               list.add(f);
	               map.put(f.id , list);
	            
	            }
	            else{
	                List<Folder> newL = new ArrayList<>();
	                newL.add(f);
	                map.put(f.id , newL);
	            }
	        }
	        dfs(9 , map , new HashSet<>();
	        
	        print set;
	    }
	    
	    public static void dfs(Integer id , Map<Integer , List<Folder>> map , Set<String> set){
	        //printPath(9) = “abc” -> “ijk” -> “lmn” printPath(8) = ""
	    List<Folder> folders = map.get(id);
	    
	    if(folders != null)
	    for(Folder fold : folders){ 
	     System.out.println(fold.id); //->0 
	      System.out.println(fold.name); // -> abc , ijk , lmn
	    for(Integer subFold : fold.subfolders){
	         
	        dfs(subFold , map);
	   
	 set.add(parentMap.get(subFold));
	   
	    }
	    
	    }
	    }
	    
	    
	    public static void main(String[] args) {
	       
	       
	       //list = [Folder(0, [7,3 ], “abc”), Folder(0, [], “xyz”), Folder(8, [], “def”), Folder(7, [9], “ijk), Folder(9, [], “lmn”)]
	       
	       Folder f = new Folder();
	       f.id=0;
	       List<Integer> list1 = new ArrayList<>();
	       list1.add(7);
	       list1.add(3);
	       f.subfolders = list1;
	       f.name="abc";
	       
	       Folder f1 = new Folder();
	       f1.id=0;
	       List<Integer> list2 = new ArrayList<>();
	       //list2.add(7);
	       //list2.add(3);
	       f1.name="xyz";
	       f1.subfolders = list2;
	       
	        Folder f2 = new Folder();
	       f2.id=8;
	       List<Integer> list3 = new ArrayList<>();
	       //list2.add(7);
	       //list2.add(3);
	       f2.name="def";
	       f2.subfolders = list3;
	       
	       Folder f3 = new Folder();
	       f3.id=7;
	       List<Integer> list4 = new ArrayList<>();
	       list4.add(9);
	     
	       f3.name="ijk";
	       f3.subfolders = list4;
	       
	        Folder f4 = new Folder();
	       f4.id=9;
	       List<Integer> list5 = new ArrayList<>();
	       
	       f4.subfolders = list5;
	       f4.name="lmn";
	       
	     
	       
	       List<Folder> folders = new ArrayList<>();
	       folders.add(f);
	       folders.add(f1);
	       folders.add(f2);
	       folders.add(f3);
	       folders.add(f4);
	       printPath(folders);

	    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
