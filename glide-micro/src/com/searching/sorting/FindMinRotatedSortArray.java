package com.searching.sorting;

public class FindMinRotatedSortArray {
	
	public int findMin(int[] A) {
        int low = 0;
        int high = A.length-1;
        // Find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and low or high 
        // will shrink by at least 1.
        
        // Proof by contradiction that mid < high: if mid==high, 
        // then low == high and loop would have been terminated.
        while(low < high){
            int mid = (low + high)/2;
            if(A[mid] > A[high]){
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        return A[low];
        
    }
	//once find the rotation index then apply binary search by finding the number
//	 int rot=low;
//     low = 0;
//     high = n-1;
//     // The usual binary search and accounting for rotation.
//     while(low <= high){
//         int mid = (low + high)/2;
//         int realmid=(mid + rot) % n;
//         if(A[realmid] == target){
//             return realmid;
//         }
//         if( target > A[realmid] ){
//             low = mid+1;
//         }
//         else {
//             high = mid-1;
//         }
//     }
//     return -1;
 //}

}
