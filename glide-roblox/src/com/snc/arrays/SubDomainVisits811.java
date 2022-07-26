package com.snc.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*https://leetcode.com/problems/subdomain-visit-count/ 
 * A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.

For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input. You may return the answer in any order.


 * 
 * 
 * */

public class SubDomainVisits811 {
	
public static List<String> subdomainVisits(String[] cpdomains){
		
		Map<String , Integer> counts = new HashMap<>();
		
		for(String domain : cpdomains) {
			//getting hits by taking the string with index of space
			int hits = Integer.parseInt(domain.substring(0, domain.indexOf(" ")));
			String curr = domain.substring(domain.indexOf(" ")+1);
			while(!curr.isEmpty()) {
				//seperating every dot and parsing it into map
				counts.put(curr ,  counts.getOrDefault(curr, 0) + hits);
				int idx = curr.indexOf(".");
				if(idx != -1) {
					curr = curr.substring(idx+1);
				}
				else {
					curr = "";
				}
			}
		}
		
		List<String> ans = new ArrayList<>();
		
		for(String key : counts.keySet()) {
			int count= counts.get(key);
			String toAdd = count+ " " +key;
			ans.add(toAdd);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] domains = {"9001 discuss.leetcode.com"};

		subdomainVisits(domains);
	}

}
