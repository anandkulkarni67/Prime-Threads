
package primeThreads.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;

/**
 * <p>
 * This class is responsible for following functions: </br>
 * 1. Entering data into result set. </br>
 * 2. calculating sum of the each element of the result set. </br>
 * 3. Displaying the final result.
 * </p>
 * 
 * @author Anand Kulkarni
 *
 */
public class Results implements StdoutDisplayInterface, ResultsInterface {
	
	
	List<Integer> listOfPrimes = null;

	public Results() {
		Logger.writeMessage("Constructor of " + this.getClass().getSimpleName() + " class is called",
				DebugLevel.CONSTRUCTOR);
		listOfPrimes = new ArrayList<Integer>();
	}

	/**
	 * <p>
	 * This method is responsible for adding data to the result set.
	 * </p>
	 * 
	 * @param number
	 * @return none
	 */
	public synchronized void insert(int number) {
		listOfPrimes.add(number);
		Logger.writeMessage("[" + number + "] is added to the collection of prime numbers.", DebugLevel.DATA_ENTRY);
	}

	/**
	 * <p>
	 * This method is responsible for calculating the sum of elements from the
	 * result set and displaying it.
	 * </p>
	 * 
	 * @return none
	 */
	public void writeSumToScreen() {
		Logger.writeMessage("Contents of the collection are - \n" + this.listOfPrimes, DebugLevel.CONTENTS);
		int sum = listOfPrimes.stream().mapToInt(Integer::intValue).sum();
		Logger.writeMessage("The sum of all the prime numbers is: " + sum, DebugLevel.RESULT);
	}

	@Override
	public String toString() {
		return "Results [listOfPrimes=" + listOfPrimes + "]";
	}
}
