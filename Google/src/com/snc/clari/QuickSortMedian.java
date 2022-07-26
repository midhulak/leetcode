package com.snc.clari;

public class QuickSortMedian {
	
	public static int partition(int[] arr, int low , int high) {
		
		int i=low-1;
	
		int pivot = arr[high];
		for(int j=low ; j < high ; j++) {
			
			
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
		
	}
	
	public static int[] quickSort(int[] arr , int low , int high , int medianIndex) {
		
		
		if(low < high) {
			
			int pi = partition(arr , low , high);
			
			if(pi == medianIndex)
				return arr;
			
			quickSort(arr , low , pi-1 , medianIndex);
			 quickSort(arr , pi+1 , high , medianIndex);
			
		}
		return arr;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {12,5 ,6 ,8 ,10, 1 , 3 , 7}; //1 3 5 6 ,7 8 10 12
		int[] median= {-1, -1};
		
		if(array.length%2 == 0)
		{
			int[] arr1 = quickSort(array , 0 , array.length-1 , array.length/2);
			int[] arr2 = quickSort(arr1 , 0 , array.length-1 , array.length/2+1);
			
			System.out.println("median even  is="+( (arr1[array.length/2] + arr2[(array.length/2)+1])/2 ) );
			
		}
		else {
			int[] arr1 = quickSort(array , 0 , array.length-1 , array.length/2);
			System.out.println("median odd is="+(arr1[array.length/2] ));
		}
		

	}

}
