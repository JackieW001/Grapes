/*======================================
  class MergeSortTester
  ALGORITHM:
  Imagine a binary tree. The array of ints rests at the top of the tree. Each time you
  go down a level of the tree, the array of ints splits in half. The tree continues until 
  each element is in its own array, i.e. each array only has one element in it. 
  To build up the sorted array of ints, compare the first elements of
  two of the arrays. Place the element that is smaller in an empty sorted
  array. Continue to compare the first elements of the lists and place them in the 
  sorted array until one array is empty. Add the rest of the elements of the second
  array into the sorted array. Repeat until you reach the top of the tree, where a
  fully sorted array awaits.


  
  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(nlogn)
  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 54591 (30000 ~ 55000)
  n=10      time: 253098 (200000 ~ 300000)
  n=100     time: 1400962 (1300000 ~ 1900000)
  ...
  n=<huge>  time: nlogn
  ANALYSIS:
  Each time the array is split in half, it is considered O(logn). [It is similar to 
  a binary search runtime since binary searches also utilizes finding the center or 
  midpoint of the array by dividing it in half.]
  The number of times the array is split in half is O(n). [Levels of the binary tree]
  Therefore, the runtime is O(nlogn).
  ======================================*/

public class MergeSortTester {
     /*******************************
     execution time analysis 
     Take system time (in nanoseconds) before sort and after sort. 
     Subtract two values to find total time elapsed.
     ******************************/
    
    public static void test(int l, int b) {
	MergeSort ms = new MergeSort();
	double[] r = new double[l];
	System.out.println("running " + b + " tests (batch size) on arrays of sizes 101 to " + l); // + "\nsize:\tavg runtime\tratio to previous\tnlogn ratio");
	//for every array length from 1 to l
	for(int i = 2001; i < l + 1; i++) {
	    //run b test cases
	    for(int j = 0; j < b; j++) {
		int[] t = rfill(i);
		long st = System.currentTimeMillis();
		ms.sort(t);
		long et = System.currentTimeMillis();
		r[i - 1] += (et - st);
	    }
	    //r[i - 1] /= b;
	    System.out.println("(" + i + "," + r[i - 1] + ")"); // + "\t"+r[i-1]/(i > 1 ? r[i-2] : r[i-1]) + "\t" + (i > 1 ? (i*Math.log(i))/(Math.log(i-1)*(i-1)) : 1));
	}
    }
    
    public static int[] rfill(int s) {
	int[] a = new int[s];
	for(int i = 0; i < a.length; i++) {
	    a[i] = (int)(Math.random()*10000);
	}
	return a;
    }
	

    public static void main(String[] args) {
    	/*
	MergeSort ms = new MergeSort();
	int[] oneItem = {(int)(Math.random()*101)};
	
	int[] tenItem = new int[10];
	for (int i = 0; i < tenItem.length; i++){
	    tenItem[i] = (int)(Math.random()*101);
	}
	
	int[] hundredItem = new int[100];
	for (int i = 0; i < hundredItem.length; i++){
	    hundredItem[i] = (int)(Math.random()*101);
	}
	
	int[][] lists = {oneItem, tenItem, hundredItem};
	for (int i = 0; i < lists.length; i ++){
	    int[] itemList = lists[i];
	    ms.printArray(itemList);
	    
	    long startTime = System.nanoTime();
	    ms.printArray( ms.sort(itemList) );
	    
	    long endTime   = System.nanoTime();
	    long totalTime = endTime - startTime;
	    
	    System.out.println("Total time: " + totalTime + " nano seconds" );
	    }
	*/
	test(10000000,1000);	
    }//end main
    
}// end class
