package numberrangesummarizer;
import java.util.ArrayList;
import java.util.Collection;

/**
 *<p>NumberRanger class that implements NumberRangeSummarizer
 * to split numbers into their respective ranges.</p>
 *@author Gerald Joshua Ngumbulu
 *@version 1.0
 */
public class NumberRanger implements NumberRangeSummarizer{

	/**
	 *<p>implementation of the abstract method in numberrangesummarizer class.
	 *Creates an new object of collection integer array that takes in the values to be grouped
	 *into their respective ranges(Time complexity: O(n))</p>
	 *@param input the sample input string.
	 *@return Collection of Integers obtained from the input string.
	 *
	 */

	public Collection<Integer> collect(String input){
		String[] inputarray = input.split(",");
		Collection<Integer> inputCollection = new ArrayList<>();
		for(int i=0;i<inputarray.length;i++){
			inputCollection.add(Integer.parseInt(inputarray[i]));
		}
		return inputCollection;

	}

	/**
	 *<p>implementation of the abstract method in numberrangesummarizer class.
	 *Reads the collection integer array and converts the collection to a array 
	 *and loops the array to obtain the desired result.(Time complexity: O(n)). 
	 *The method uses brute-force Algorthim</p>
	 *@param input A Collection of integers in an array.
	 *@return String containing comma delimitted range of numbers grouped into their respective ranges.
	 *
	 */
	public String summarizeCollection(Collection<Integer> input){
		Integer [] inputArray = input.toArray(new Integer[input.size()]);
		String numberListStr = "";
		ArrayList<Integer> collectionOfInteger = new ArrayList<Integer>();
		for(int i=0; i<inputArray.length;i++){
			if((i+1)<inputArray.length){
				if((inputArray[i]+1)==inputArray[i+1]){
					collectionOfInteger.add(inputArray[i]);
				}
				else if(!collectionOfInteger.isEmpty()){
					collectionOfInteger.add(inputArray[i]);
					numberListStr+=collectionOfInteger.get(0)+"-"+collectionOfInteger.get(collectionOfInteger.size()-1)+", ";
					collectionOfInteger.clear();
				}
				else{
					numberListStr+=inputArray[i]+", ";
				}
			}
			else if(inputArray[i-1]+1==inputArray[i]){
				collectionOfInteger.add(inputArray[i]);
				numberListStr+=collectionOfInteger.get(0)+"-"+collectionOfInteger.get(collectionOfInteger.size()-1);
			}
			else{
				numberListStr+=inputArray[i];
			}
		}
		return numberListStr;

		
	}

	public static void main(String[]args){
		String sampleInput= "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		NumberRanger numberSplitter = new NumberRanger();
		System.out.println(numberSplitter.summarizeCollection(numberSplitter.collect(sampleInput)));
	}
}