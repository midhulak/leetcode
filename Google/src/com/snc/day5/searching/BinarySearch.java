package com.snc.day5.searching;

public class BinarySearch {
	
	public static int binarySearch(int[] a , int val) {
		
		int l=0;
		int h = a.length-1;
		
		while(l<=h) {
			
			int mid = l+(h-l)/2;
			
			if(a[mid] == val )
				return mid;
			
			if(a[mid] < val)
				l=mid+1;
			else //if(a[mid] > val
				h = mid-1;
		}
		
		return -1;
	}
	
	//point of rotation in sorted search arary
	
	public static int ptOfRotation(int[] a) {
		
		int l=0;
		int h=a.length-1;
		
		while(l <= h) {
			
			int mid = l+(h-l)/2;
			
			if( a[mid] > a[mid+1])
				return mid+1;
			
			if(a[mid] > a[0])
				l=mid+1;
			else
				h=mid-1;
			
		}
		
		return -1;
	}
	
	public static int searchRotatedSorted(int[] a , int val) {
		int rot = ptOfRotation(a);
		if(rot != -1) {
		int low=rot;
		int high = a.length-1;
		
		while(low <= high) {
			
			int mid = low+(high-low)/2;
			
			int realMid = (mid + rot)%a.length;
			
			if(a[realMid] == val)
				return realMid;
			
			if(a[realMid] < val)
				low = mid+1;
			
			else
				high = mid-1;
				
			
			
		}
		
		return -1;
		}
		return binarySearch(a , val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {4,5,6,7,8,9,1,2,3};
		System.out.println(searchRotatedSorted(a , 8));
		
	}

}
