
package primeThreads.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import primeThreads.store.StdoutDisplayInterface;
import primeThreads.threadMgmt.CreateWorkers;
import primeThreads.store.Results;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;

import static primeThreads.util.Constants.FILE_NAME_IDX;
import static primeThreads.util.Constants.DEBUG_LEVEL_IDX;
import static primeThreads.util.Constants.NUM_THREADS_IDX;
import static primeThreads.util.Constants.MAX_DEBUG_LVL;
import static primeThreads.util.Constants.MAX_THREADS;
import static primeThreads.util.Constants.MIN_DEBUG_LVL;
import static primeThreads.util.Constants.MIN_THREADS;

/**
 * <p>
 * This class contains the <b>main</b> method. It also contains the logic for
 * validating command line arguments.
 * </p>
 * 
 * @author Anand Kulkarni
 *
 */
public class Driver {

	public static void main(String args[]) {
		Driver driver = new Driver();
		if (driver.validateArguments(args)) {
			Logger.setDebugValue(Integer.parseInt(args[2]));
			FileProcessor fileProcessor = new FileProcessor(args[FILE_NAME_IDX]);
			StdoutDisplayInterface results = new Results();
			IsPrime isPrime = new IsPrime();
			CreateWorkers worker = new CreateWorkers(fileProcessor, results, isPrime);
			worker.startWorkers(Integer.parseInt(args[1]));
			results.writeSumToScreen();
			fileProcessor.closeFile();
		}
	} // end main(...)

	/**
	 * <p>
	 * This method validates command line arguments.
	 * </p>
	 * 
	 * @param args
	 *            command line arguments.
	 * @return true if arguments are valid. false otherwise.
	 */
	private boolean validateArguments(String[] args) {
		if (args.length != 3) {
			System.err.println("Please enter valid number of arguments !!!");
			System.exit(1);
		}
		File file = new File(args[FILE_NAME_IDX]);
		if (file.isFile() && file.canRead()) {
			try {
				new FileInputStream(file);
			} catch (IOException exception) {
				System.err.println("File Stream could not be created." + exception.getStackTrace().toString());
				System.exit(1);
			}
		}
		if (formatCheck(args[NUM_THREADS_IDX]) && rangeCheck(args[NUM_THREADS_IDX], MIN_THREADS, MAX_THREADS)) {
			System.err.println("Invalid number of threads. Please enter a value between 1 and 5 (Inclusive).");
			System.exit(1);
		}
		if (formatCheck(args[DEBUG_LEVEL_IDX]) && rangeCheck(args[DEBUG_LEVEL_IDX], MIN_DEBUG_LVL, MAX_DEBUG_LVL)) {
			System.err.println("Invalid debug level. Please enter a value between 0 and 4 (Inclusive).");
			System.exit(1);
		}
		return true;
	}

	/**
	 * <p>
	 * This method validates if the value of an argument lies within the
	 * specified range.
	 * </p>
	 * 
	 * @param arg
	 *            argument to be checked for range.
	 * @param low
	 *            minimum acceptable value of the argument.
	 * @param high
	 *            maximum acceptable value of the argument.
	 * @return true if the input argument lies within the specified range, false
	 *         otherwise.
	 */
	private boolean rangeCheck(String arg, int low, int high) {
		int val = Integer.parseInt(arg);
		return (val < low) || (val > high);
	}

	/**
	 * <p>
	 * This method validates if argument can be casted to an Integer Value.
	 * </p>
	 * @param arg argument to be validated.
	 * @return true if the input argument is in valid format, otherwise exits the application. 
	 */
	private boolean formatCheck(String arg) {
		try {
			Integer.parseInt(arg);
		} catch (NumberFormatException exception) {
			System.err.println("Please enter an argument in valid format !!");
			System.exit(1);
		}
		return true;
	}

}