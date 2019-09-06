package numberrangesummarizer;
//import numberrangesummarizer.NumberRangeSummarizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NumberRanger implements NumberRangeSummarizer{


	
	public Collection<Integer> collect(String input){
		String[] inputarray = input.split(",");
		Collection<Integer> x = new ArrayList<>();
		for(int i=0;i<inputarray.length;i++){
			x.add(Integer.parseInt(inputarray[i]));
		}
		return x;

	}

	
	public String summarizeCollection(Collection<Integer> input){
		Integer [] inputArray = input.toArray(new Integer[input.size()]);
		String numberList = "";
		ArrayList<Integer> collectionOfInteger = new ArrayList<Integer>();
		for(int i=0; i<inputArray.length;i++){
			//System.out.println(y[i]);
			if((i+1)<inputArray.length){
				if((inputArray[i]+1)==inputArray[i+1]){
					collectionOfInteger.add(inputArray[i]);
				}
				else if(!collectionOfInteger.isEmpty()){
					collectionOfInteger.add(inputArray[i]);
					numberList+=collectionOfInteger.get(0)+"-"+collectionOfInteger.get(collectionOfInteger.size()-1)+", ";
					collectionOfInteger.clear();
				}
				else{
					numberList+=inputArray[i]+", ";
				}
			}
			else if(inputArray[i-1]+1==inputArray[i]){
				collectionOfInteger.add(inputArray[i]);
				numberList+=collectionOfInteger.get(0)+"-"+collectionOfInteger.get(collectionOfInteger.size()-1);
			}
			else{
				numberList+=inputArray[i];
			}
		}
		return numberList;

		
	}

	public static void main(String[]args){
		String u= "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		NumberRanger t = new NumberRanger();
		System.out.println(t.summarizeCollection(t.collect(u)));
	}
}