package com.snc.trees.graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/** https://leetcode.com/problems/employee-importance/ **/
//Time Complexity: O(N)O(N), where NN is the number of employees. We might query each employee in dfs.

//Space Complexity: O(N)O(N), the size of the implicit call stack when evaluating dfs.



//You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.
//
//You are given an array of employees employees where:
//
//employees[i].id is the ID of the ith employee.
//employees[i].importance is the importance value of the ith employee.
//employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
//Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.
//
// 
//
//Example 1:
//
//
//Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
//Output: 11
//Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
//They both have an importance value of 3.
//Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.
//Example 2:


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
