
package primeThreads.util;

/**
 * This class is responsible for checking whether a number is prime.
 * 
 * @author Anand Kulkarni
 *
 */
public class IsPrime {

	/**
	 * <p>
	 * This method is responsible for checking whether a givem number is prime
	 * or not.
	 * </p>
	 * 
	 * @param number
	 *            number to be checked.
	 * @return true if the given number is prime, false otherwise.
	 */
	public boolean isPrime(int number) {
		int upperLimit = (int) Math.sqrt(number);
		for (int i = 2; i <= upperLimit; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "IsPrime []";
	}

}
