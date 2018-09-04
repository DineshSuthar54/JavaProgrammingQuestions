/**
 * 	Algorithm Used "Bucket Sort"
 * 	Time Complexity = O(n+k)
 *  Space Complexity = O(k)
 *  
 *  We can use Counting sort as well as Bucket Sort in this case as we have Bounded range 
 *  of the numbers.
 *    
 */
import java.util.*;
import java.lang.*;

/**
 * 
 * @author Pankaj Suthar
 *
 */
public class SortArray
{

	/**
	 * 
	 * @param size
	 * @param low
	 * @param high
	 * @return Randomly Generated No Between 0 to 100
	 */
	private static int[] generateInts(int size, int low, int high) {
		int[] numbers = new int[size];
		for(int i = 0 ; i < size ; i++) {
			numbers[i] = (int)((Math.random() * high) + low);
		}
		return numbers;
	}
	
	/**
	 * Method to sort array 
	 * @param numbers
	 * @param low
	 * @param high
	 */
	private static void bucketSort(int[] numbers, int low, int high) {
		int range = high - low + 1;
		int[] buckets = new int[range];
		int length = numbers.length;
		for(int i = 0 ; i < length ; i++) {
			buckets[numbers[i] - 1]++;
		}
		int index = 0;
		for(int i = 0 ; i < range ; i++) {
			int count = buckets[i];
			for(int j = 0 ; j < count ; j++) {
				numbers[index++] = i + 1;
			}
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int size = 10000000;
		int low = 1;
		int high = 100;
		
		long start = System.currentTimeMillis();
		int[] numbers = generateInts(size, low, high);
		long end = System.currentTimeMillis();
		System.out.println("Numbers generated in - " + (end - start)+" ms");
		
		bucketSort(numbers, low, high);
		long sorted = System.currentTimeMillis();
		
		System.out.println("Sorted in - " + (sorted - end)+" ms");
		System.out.println("Sorted numbers are : " );
		for(int i = 0 ; i < size ;  i++) {
			System.out.print(numbers[i]+" ");
			
		}
	}
}