package com.snc.compass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisit {
	
	public static List<String> subdomainVisits(String[] cpdomains){
		
		Map<String , Integer> counts = new HashMap<>();
		
		for(String domain : cpdomains) {
			
			int hits = Integer.parseInt(domain.substring(0, domain.indexOf(" ")));
			String curr = domain.substring(domain.indexOf(" ")+1);
			while(!curr.isEmpty()) {
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
		
		String[] str = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		
		subdomainVisits(str);
	}

}
