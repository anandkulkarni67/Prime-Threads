
package primeThreads.threadMgmt;

import primeThreads.store.StdoutDisplayInterface;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;
import primeThreads.store.ResultsInterface;

/**
 * <p>
 * This class implements Runnable interface.
 * </p>
 * 
 * @author Anand Kulkarni
 *
 */
public class WorkerThread implements Runnable {

	private FileProcessor fileProcessor = null;
	private ResultsInterface results = null;
	private IsPrime isPrime = null;

	public WorkerThread(FileProcessor fileProcessorIn, StdoutDisplayInterface resultsIn, IsPrime isPrimeIn) {
		Logger.writeMessage("Constructor of " + this.getClass().getSimpleName() + " class is called",
				DebugLevel.CONSTRUCTOR);
		fileProcessor = fileProcessorIn;
		results = (ResultsInterface) resultsIn;
		isPrime = isPrimeIn;
	}

	/**
	 * This method is invoked by all threads.
	 * 
	 * @return none
	 */
	public synchronized void run() {
		Logger.writeMessage("Thread " + Thread.currentThread().getName() + " entered run() method", DebugLevel.RUN);
		String line = null;
		while ((line = fileProcessor.readLineFromFile()) != null) {
			int number = Integer.parseInt(line);
			if (isPrime.isPrime(number)) {
				results.insert(number);
			}
		}
	}
}