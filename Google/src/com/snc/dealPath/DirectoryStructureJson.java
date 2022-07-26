package com.snc.dealPath;
import java.io.File;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DirectoryStructureJson {
	
	JSONObject json = new JSONObject();
	
	JSONArray jsonArr = new JSONArray();
	
	class Dir{
		
		String path;
		String name;
		String type;
		Children children;
	}
	
	class Children{
		
		Dir dir;
		
	}
	public String printDirStructure(File dir) {
		if(dir.isFile())
		{
			if(dir.getAbsolutePath().contains(".DS_Store"))
				return "";
			System.out.println("fiel name is="+dir.getAbsolutePath());
			Children child = new Children();
			Dir d = new Dir();
			d.name=dir.getName();
			d.path=dir.getParent();
			d.type="file";
			
			child.dir = d;
			
			return child.toString();
		}
		
		if(dir.exists()) {
			
			File[] files = dir.listFiles();
			
			for(int i=0 ; i<files.length; i++) {
				
		     if(files[i].isDirectory()) {
		    	 
		    	 JSONObject json = new JSONObject();
		    	 json.put("type" , "directory");
		    	 json.put("name" , files[i].getName());
		    	 json.put("path", files[i].getParent());
		    	 
		    	
//		    	 Dir d = new Dir();
//		    	 d.type="directory";
//		    	 d.name=files[i].getName();
//		    	 d.path = files[i].getParent();
		    	 
			String children =	printDirStructure(files[i]);
			
			json.put("children", children);
			
			jsonArr.add(json);
			
		     }
				
				
			}
			
		}
		System.out.println("josn string is="+jsonArr.toString());
	return jsonArr.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DirectoryStructureJson d = new DirectoryStructureJson();
		d.printDirStructure(new File("/Users/midhula.kadiyala/Documents/dealPath"));
	}

}
