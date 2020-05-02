
package primeThreads.threadMgmt;

import java.util.List;
import java.util.ArrayList;
import primeThreads.store.StdoutDisplayInterface;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;

/**
 * <p>
 * This class creates and initializes worker threads.
 * </p>
 * 
 * @author Anand Kulkarni
 *
 */
public class CreateWorkers {

	private FileProcessor fileProcessor = null;
	private StdoutDisplayInterface results = null;
	private IsPrime isPrime = null;

	public CreateWorkers(FileProcessor fileProcessorIn, StdoutDisplayInterface resultsIn, IsPrime isPrimeIn) {
		Logger.writeMessage("Constructor of " + this.getClass().getSimpleName() + " class is called",
				DebugLevel.CONSTRUCTOR);
		fileProcessor = fileProcessorIn;
		results = resultsIn;
		isPrime = isPrimeIn;
	}

	/**
	 * <p>
	 * This method is responsible for creating threads.
	 * </p>
	 * 
	 * @param noThreads
	 *            number of threads to be spawned.
	 * @return none
	 */
	public void startWorkers(int noThreads) {
		List<Thread> threads = new ArrayList<Thread>();
		for (int count = 0; count < noThreads; count++) {
			WorkerThread workerThread = new WorkerThread(this.fileProcessor, this.results, this.isPrime);
			Thread thread = new Thread(workerThread, String.valueOf(count));
			thread.start();
			threads.add(thread);
		}

		threads.stream().forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException exception) {
				System.err.println("Error occured while joining a thread !!");
				exception.printStackTrace();
				System.exit(1);
			}
		});

	}
}