package numberrangesummarizer;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.IOException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;

public class NumberRangerTest{
	NumberRanger test = new NumberRanger();
	Collection<Integer> inputCollection_1; 
	Collection<Integer> inputCollection_2;
	Collection<Integer> inputCollection_3;

	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
		System.out.println("Testing methods in the NumberRanger class: ");
	}


	@Test
	public void testCollect(){
		System.out.println("Test 1: Testing method collect() in the NumberRanger class: ");
		String sampleInput_1 = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		String sampleInput_2 = "1,3,6,7,8,12,13,14,15,21,22,23,24,25";
		String sampleInput_3 = "1,3,6,7,8,12,13,22,23,24,31,40";
		Collection<Integer> sampleOutput_1= new ArrayList<>(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31));
		Collection<Integer> sampleOutput_2= new ArrayList<>(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,25));
		Collection<Integer> sampleOutput_3= new ArrayList<>(Arrays.asList(1,3,6,7,8,12,13,22,23,24,31,40));
		inputCollection_1 = test.collect(sampleInput_1);
		inputCollection_2 = test.collect(sampleInput_2);
		inputCollection_3 = test.collect(sampleInput_3);
		assertEquals(sampleOutput_1.size(),inputCollection_1.size());
		assertEquals(sampleOutput_2.size(),inputCollection_2.size());
		assertEquals(sampleOutput_3.size(),inputCollection_3.size());
		assertEquals(false,inputCollection_3.contains(25));
		System.out.println("Test 1: completed");

	}
	@Test
	public void testSummarizeCollection(){
		System.out.println("Test 2: Testing method collect() in the NumberRanger class: ");
		String sampleInput_1 = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		String sampleInput_2 = "1,3,6,7,8,12,13,14,15,21,22,23,24,25";
		String sampleInput_3 = "1,3,6,7,8,12,13,22,23,24,31,40";
		Collection<Integer> sampleOutput_1= new ArrayList<>(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31));
		Collection<Integer> sampleOutput_2= new ArrayList<>(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,25));
		Collection<Integer> sampleOutput_3= new ArrayList<>(Arrays.asList(1,3,6,7,8,12,13,22,23,24,31,40));
		inputCollection_1 = test.collect(sampleInput_1);
		inputCollection_2 = test.collect(sampleInput_2);
		inputCollection_3 = test.collect(sampleInput_3);
		String inputList_1=test.summarizeCollection(inputCollection_1);
		String inputList_2=test.summarizeCollection(inputCollection_2);
		String inputList_3=test.summarizeCollection(inputCollection_3);
		String expectedInput_1 = "1, 3, 6-8, 12-15, 21-24, 31";
		String expectedInput_2 = "1, 3, 6-8, 12-15, 21-25";
		String expectedInput_3 = "1, 3, 6-8, 12-13, 22-24, 31, 40";
		assertEquals(true,expectedInput_2.equals(inputList_2));
		assertEquals(expectedInput_1.length(),inputList_1.length());
		assertEquals(false,expectedInput_3.equals(inputList_1));
		System.out.println("Test 2:completed");
	}

}