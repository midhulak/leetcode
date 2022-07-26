package com.snc.phone.trees;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class AccountsMerge {
	
	//created a graph and added nodes into it..
	// accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
	//map with name
	//map with key as email and value as name and built a graph liek above
	//{johnnybravo@mail.com=john, johnsmith@mail.com=john, john00@mail.com=john, john_newyork@mail.com=john, mary@mail.com=Mary}

	//ggraph
	//{johnnybravo@mail.com=[], johnsmith@mail.com=[john00@mail.com, john_newyork@mail.com], john00@mail.com=[johnsmith@mail.com], john_newyork@mail.com=[johnsmith@mail.com], mary@mail.com=[]}

	//and create a hashset and iterate mail to name map and for each mail add to visited and check all of its neighbours and add name at zero postionan d add it rto the result.
	class Solution {
	    
	    /**
	    Here NN is the number of accounts and KK is the maximum length of an account.

	Time complexity: O(NK \log{NK})O(NKlogNK)

	In the worst case, all the emails will end up belonging to a single person. The total number of emails will be N*KN∗K, and we need to sort these emails. DFS traversal will take NKNK operations as no email will be traversed more than once.

	Space complexity: O(NK)O(NK)

	Building the adjacency list will take O(NK)O(NK) space. In the end, visited will contain all of the emails hence it will use O(NK)O(NK) space. Also, the call stack for DFS will use O(NK)O(NK) space in the worst case.

	The space complexity of the sorting algorithm depends on the implementation of each programming language. For instance, in Java, Collections.sort() dumps the specified list into an array this will take O(NK)O(NK) space then Arrays.sort() for primitives is implemented as a variant of quicksort algorithm whose space complexity is O(\log NK)O(logNK). In C++ sort() function provided by STL is a hybrid of Quick Sort, Heap Sort, and Insertion Sort with the worst-case space complexity of O(\log NK)O(logNK).
	**/
	      public List<List<String>> accountsMerge(List<List<String>> accounts) {
	        List<List<String>> res = new ArrayList<>();
	        if (accounts.size() == 0) return res;
	        Map<String, Set<String>> g = new HashMap<>();
	        Map<String, String> mailToName = new HashMap<>();
	        buildGraph(g, accounts, mailToName);
	        
	        Set<String> visited = new HashSet<>();
	        for (String mail: mailToName.keySet()) {
	            String name = mailToName.get(mail);
	            List<String> mails = new ArrayList<>();
	            if (visited.add(mail)) {
	                dfs(mails, mail, g, visited);
	                Collections.sort(mails);
	                mails.add(0, name);
	                res.add(mails);
	            }
	        }
	        
	        return res;
	    }
	    
	    private void dfs(List<String> mails, String mail, Map<String, Set<String>> g, Set<String> visited) {
	        mails.add(mail);
	        if (g.get(mail).size() == 0) return;
	        for (String neigh: g.get(mail)) {
	            if (visited.add(neigh)) {
	                dfs(mails, neigh, g, visited);
	            }
	        }
	    }
	    
	    private void buildGraph(Map<String, Set<String>> g, List<List<String>> accounts, Map<String, String> mailToName) {
	        for (List<String> account: accounts) {
	            String name = account.get(0);
	            for (int i = 1; i < account.size(); i++) {
	                String mail = account.get(i);
	                mailToName.put(mail, name);
	                g.putIfAbsent(mail, new HashSet<>());
	                if (i == 1) continue;
	                String prev = account.get(i - 1);
	                //TRY TO ADD neighbours of each email in the same list.and check if those email neighbours present in other set we can combine.
	                g.get(prev).add(mail);
	                g.get(mail).add(prev);
	            }
	        }
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
