package com.snc.pluginChanges;

import java.util.List;

public class MissingElementsOne {
	
	public static<T> int firstIndexOfElementInArray(T element , List<T> list) {
		
		int result = -1;
		
		for(int i=0; i < list.size(); i++) {
			if(list.get(i).equals(element))
				return i;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
