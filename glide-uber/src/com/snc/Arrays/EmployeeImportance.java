package com.snc.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
	
	class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	};
	
	 public int getImportance(List<Employee> employees, int id) {
	        Map<Integer , Employee> map =new HashMap<>();
	        for(Employee emp : employees){
	            map.put(emp.id , emp);
	        }
	         return dfs(map  , id , 0);
	        
	    }
	    
	    
	    public int dfs(Map<Integer , Employee> map ,  int id , int res){
	       
	       Employee emp = map.get(id);
	      int imp = emp.importance;
	   
	        for(Integer empId : emp.subordinates ){
	        
	           imp+= dfs(map   , empId , res);
	        }
	      
	       return imp;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
