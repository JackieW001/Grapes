/*
Jackie Woo
APCS2 pd1
HW #07: What does the data say?
2017-02-13
*/

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  Imagine a binary tree. The array of ints rests at the top of the tree. Each time you
  go down a level of the tree, the array of ints splits in half. The tree continues until 
  each element is in its own array, i.e. each array only has one element in it. 
  To build up the sorted array of ints, compare the first elements of
  two of the arrays. Place the element that is smaller in an empty sorted
  array. Continue to compare the first elements of the lists and place them in the 
  sorted array until one array is empty. Add the rest of the elements of the second
  array into the sorted array. Repeat until you reach the top of the tree, where a
  fully sorted array awaits.
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
    	int[] merged = new int [a.length+b.length];
    	
		int i = 0; // a index
		int j = 0; // b index
		int z = 0; // merged index
		while (i < a.length && j < b.length){
			if (a[i] <= b[j]){
				merged[z] = a[i];
				i++;
			}
			else {
				merged[z] = b[j];
				j++;
			}
		z++;
		}
		while (i <= a.length-1 ){
			merged[z] = a[i];
			z++;
			i++;
		}
		while ( j <= b.length-1 ){
			merged[z] = b[j];
			z++;
			j++;
		}
		
		return merged;
		
		
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
    	int[] sorted = new int[arr.length];
    	int[] arr1 = new int[arr.length/2];
    	int[] arr2 = new int[arr.length-arr1.length];
		if (arr.length == 1){
			return arr;
		}
		
		// copy contents of arr to arr1 and arr2 (splitting)
		for(int i = 0; i < arr.length; i++){
			if (i < arr.length/2){
				arr1[i] = arr[i];
			}
			else{
				arr2[i-(arr.length/2)] = arr[i];
			}
		}
		
		arr1 = sort(arr1);
		arr2 = sort(arr2);
		
		sorted = merge(arr1,arr2);
		
		return sorted;
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


}//end class MergeSort

