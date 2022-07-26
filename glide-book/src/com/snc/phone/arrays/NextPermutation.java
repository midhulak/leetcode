package com.snc.phone.arrays;

public class NextPermutation {
	// https://leetcode.com/problems/next-permutation/solution/

//  Time complexity : O(n)O(n). In worst case, only two scans of the whole array are needed.

//Space complexity : O(1)O(1). No extra space is used. In place replacements are done.
 public void nextPermutation(int[] nums) {
     int i= nums.length-2;
     
    // find out the number which is strictly decreasing from end that is i
     //if i > 0 then again set j to end of array and compare i with j
     //if j is greater then i then swap it
     //again increment i to +1 and set j to end of array and do swap of i and j until i < j (by incrementing i and decrement j)
     
     while(i>=0 && nums[i+1] <= nums[i]){
         i--;
     }
     
     if(i >= 0){
         int j = nums.length - 1;
         
         while(j >=0 && nums[j] <= nums[i]){
             j--;
         }
         
         swap(nums , i , j);
     }
     reverse(nums , i +1);
 }
 
 
 public void reverse(int[] nums , int start){
     
     int i=start, j=nums.length-1;
     
     while(i < j){
         swap(nums , i,j);
         i++;
         j--;
     }
 }
 
 private void swap(int[] nums , int i , int j){
     
     int temp = nums[i];
     nums[i] = nums[j];
     nums[j] = temp;
 }
}
