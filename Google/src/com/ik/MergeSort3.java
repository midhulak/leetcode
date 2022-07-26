package com.snc.sorting;

public class MergeSort3 {
	
	 public int[] Merge(int array[]) {

         if (array.length > 1) {
                 int elementsinarr1 = array.length / 2;
                 int elementsinarr2 = elementsinarr1;

                 if (array.length % 2 == 1) {
                         elementsinarr2 = elementsinarr1 + 1;
                 }

                 int arr1[] = new int[elementsinarr1];
                 int arr2[] = new int[elementsinarr2];

                 for (int i = 0; i < elementsinarr1; i++) {
                         arr1[i] = array[i];
                 }

                 for (int i = elementsinarr1; i < elementsinarr1 + elementsinarr2; i++)
                         arr2[i - elementsinarr1] = array[i];

                 if (arr1.length != 0) {
                         arr1 = Merge(arr1);
                         arr2 = Merge(arr2);
                 }

                 int i = 0, j = 0, k = 0;

                 while (arr1.length != j && arr2.length != k) {
                         if (arr1[j] < arr2[k]) {
                                 array[i] = arr1[j];
                                 i++;
                                 j++;
                         } else {
                                 array[i] = arr2[k];
                                 i++;
                                 k++;
                         }

                 }
                 // suppose is the elemnets left then

                 while (arr1.length != j) {
                         array[i] = arr1[j];
                         i++;
                         j++;
                 }

                 while (arr2.length != k) {
                         array[i] = arr2[k];
                         i++;
                         k++;
                 }
         }

         return array;
 }

 public static void main(String args[]) {
         int m = 0;
         int[] array = { 9, 2, 5, 1, 7, 6, 3, 8, 10 , 150};
         MergeSort3 ms = new MergeSort3();
         ms.Merge(array);

         for (m = 0; m < array.length; m++) {
                 System.out.print(array[m]+",");
         }
 }

}
