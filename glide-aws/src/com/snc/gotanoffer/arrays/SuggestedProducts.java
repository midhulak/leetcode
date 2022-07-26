package com.snc.gotanoffer.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//TC: O(len(searchWord)+productLength) + nlogn(for sorting the product)
//TC: O(m+nlogn) where m is the length of searchword and n is teh length of products

//SC: O(1)

public class SuggestedProducts {
	
	  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
          //first sorting teh products ..so that we can acheiev the condition lexographically
      Arrays.sort(products);
      List<List<String>> result = new LinkedList<>();
      for (int i = 0; i < searchWord.length(); i++) {
          //take each character from search string
          String current = searchWord.substring(0, i+1);
          List<String> prod = new LinkedList<>();
          int count = 3; //as we need only 3 strings
          for (int j = 0; j < products.length && count > 0; j++) {
              if (products[j].length() >= i + 1) {
                  if (products[j].substring(0, i + 1).equals(current)) {
                      prod.add(products[j]);
                      count--;
                  }
              }
          }
          result.add(prod);
      }
      return result;
  }
      

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
