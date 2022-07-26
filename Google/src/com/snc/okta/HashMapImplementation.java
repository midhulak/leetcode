package com.snc.okta;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HashMapImplementation {

	class HashTable{
		
		LinkedList[] data;
		
		boolean put(String key , String val) {
			Map<String , String> map = new HashMap<>();
			   map.put("midhula" , "Kadiyala");
				

			int hashCode = getHashCode(key);
			int index = converttoIndex(hashcode);
			LinkedList list = data[index];
			list.insert(key,val);
		}
		
		@override
		public int hashCode() {
			return (int)key.charAt(0);
		}
		@override
		public boolean equals(Object obj) {
			return key.equals(String )obj);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
