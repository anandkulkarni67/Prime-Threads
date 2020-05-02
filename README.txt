PROJECT <2> README FILE

Author(s): <Anand Kulkarni>

PURPOSE:

[
  The project intends to use threads for reading numbers from a text file and store only the prime numbers in a collection to calculate the sum later.
]

PERCENT COMPLETE:

[
  I believe, I have completed 100% of this project.
]

PARTS THAT ARE NOT COMPLETE:

[
  None.
]

BUGS:

[
  None.
]

FILES:

[
  Following files are included with this projectIncluded with this project are 4 files:

  Driver.java - this file has the main method.
  FileProcessor.java - this file contains logic pertaining to file operations.
  CreateWorkers.java - this file creates threads and starts execution of each thread.
  WorkerThread.java - this file contains the run() method which will be invloked by all threads.  
  Results.java - this file contains a logic to store the prime numbers and also to calculate sum of all prime numbers.
  StdoutDisplayInterface.java - this file conains an interface which is implemented by Results class.
  ResultsInterface.java - this file contains an interface which is implemented by Results class.	
  IsPrime.java - this file contains the logic to check whether a given number is prime or not.
  Logger.java - this file contains the logic for logging messages on the console.
  Constants.java - this file contains all constant values that are required throughout the application.	
  README.txt, the text file you are presently reading.
]

SAMPLE OUTPUT:

[
  remote02:~/design patterns/anand_kulkarni/Prime_Threads> ant -buildfile src/build.xml clean
  Buildfile: /import/linux/home/akulka15/design patterns/anand_kulkarni/Prime_Threads/src/build.xml

  clean:
      [delete] Deleting directory /import/linux/home/akulka15/design patterns/anand_kulkarni/Prime_Threads/BUILD

  BUILD SUCCESSFUL
  Total time: 1 second
  remote02:~/design patterns/anand_kulkarni/Prime_Threads> ant -buildfile src/build.xml
   all
  Buildfile: /import/linux/home/akulka15/design patterns/anand_kulkarni/Prime_Threads/src/build.xml

  prepare:
      [mkdir] Created dir: /import/linux/home/akulka15/design patterns/anand_kulkarni/Prime_Threads/BUILD
      [mkdir] Created dir: /import/linux/home/akulka15/design patterns/anand_kulkarni/Prime_Threads/BUILD/classes

  primeThreads:
      [javac] /import/linux/home/akulka15/design patterns/anand_kulkarni/Prime_Threads/src/build.xml:48: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last;
      set to false for repeatable builds
      [javac] Compiling 10 source files to /import/linux/home/akulka15/design patterns/anand_kulkarni/Prime_Threads/BUILD/classes

  compile_all:

  all:

  BUILD SUCCESSFUL
  Total time: 3 seconds
  remote02:~/design patterns/anand_kulkarni/Prime_Threads> ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=3 -Darg2=0
  Buildfile: /import/linux/home/akulka15/design patterns/anand_kulkarni/Prime_Threads/src/build.xml

  jar:
      [mkdir] Created dir: /import/linux/home/akulka15/design patterns/anand_kulkarni/Prime_Threads/BUILD/jar
      [jar] Building jar: /import/linux/home/akulka15/design patterns/anand_kulkarni/Prime_Threads/BUILD/jar/primeThreads.jar

  run:
      [java] The sum of all the prime numbers is: 1857

  BUILD SUCCESSFUL
  Total time: 1 second
  remote02:~/design patterns/anand_kulkarni/Prime_Threads>
]

TO COMPILE:

[
  Steps for program compilation :
  1. Traverse inside the project folder by using following command :
	cd Prime_Threads/
  2. Compile all java classes by using following command :	
	ant -buildfile src/build.xml all
]

TO RUN:

[
  Steps for program execution :
  1. Execute following command to run the program :
	ant -buildfile src/build.xml run -Darg0=<INPUT_FILE_PATH> -Darg1=<NUM_THREADS> -Darg2=<DEBUG_LVL>
	For example : ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=3 -Darg2=0
]

DATA STRUCTURES:

[
  1. ArrayList is used to store result set. All operations on vectors are synchronized. The assignment requires only insert operation on data structure to be synchronized, so ArrayList is a better 		choice since its insert operation can be synchronized by using method synchronization.
  2. ArrayList has a time complexity of O(1) while inserting and retrieving elements. Default add method inserts an element at the end of the List.
  3. ArrayList grows its size by 50% when its maximum capacity is reached whereas vectors double it's size. So ArrayList is more efficient than vectors with regards to space complexity.
]

EXTRA CREDIT:

[
  None.
]

BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<Anand Kulkarni>

[
  None.
]

ACKNOWLEDGEMENT:

[
  None.
]
