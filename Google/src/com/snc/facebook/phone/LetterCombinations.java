package com.snc.facebook.phone;

public class LetterCombinations {
	
	 public  List<String> letterCombinations(String digits){
	       
			List<String> list = new ArrayList<String>();
	       
	       if(digits.length() == 0)
	           return list;
			
			StringBuffer sb = new StringBuffer();
			
			
			Map<Character , char[]> map = new HashMap<>();
			
			map.put('0', new char[]{});
	        map.put('1', new char[]{});
	        map.put('2', new char[]{'a','b','c'});
	        map.put('3', new char[]{'d','e','f'});
	        map.put('4', new char[]{'g','h', 'i'});
	        map.put('5', new char[]{'j','k','l'});
	        map.put('6', new char[]{'m','n','o'});
	        map.put('7', new char[]{'p','q','r','s'});
	        map.put('8', new char[]{'t','u','v'});
	        map.put('9', new char[]{'w','x','y','z'});
			
			dfs(list , sb , digits , map);
			
			return list;
			
		}
		
		public static void dfs(List<String> list , StringBuffer sb , String digits , Map<Character , char[]> map) {
			
			if(sb.length() == digits.length()) {
				list.add(sb.toString());
				return;
			
			}
			
			for(char ch : map.get(digits.charAt(sb.length()))) {
				sb.append(ch);
				dfs(list , sb , digits,map);
				sb.deleteCharAt(sb.length()-1);
			}
		
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
