## Multithread parallel file system
A multithread parallel file system for determining the average length of all words in N text files


### Task
***
With the complex use of multithreading technologies (threads) and
parallel streams of the Streams API framework to create the most parallelized a synchronous system for determining the average length of all words in N texts files.

### Setup
***
In your IDE just run the Dispatcher class.
<br/>
The project comes with test files in the "files" folder.
if you want to check the system on your files, change the file path in the Dispatcher class or use setFiles method.
### Realization
***
- The FileManager class is designed to count the average word length in a set of files. It uses multithreading to process each file in parallel and a parallel stream to process each character during file processing.

- The class has two constructors: a default constructor and a parameterized constructor that takes a file path as an argument. The setFiles() method sets the files to be processed by the class based on the given file path. The method excludes hidden files from initialization.

- The countAverageWordLength() method uses multithreading to create and start threads for each file, and then waits for all threads to complete. The method uses an AtomicLong to count the total number of letters and words across all files. Finally, the method calculates and returns the average word length across all files.

- The FileThread class is a private inner class that implements the Runnable interface. This class is used by the FileManager class to process each file in parallel. The FileThread class uses a BufferedReader to read the file line by line, and a parallel stream to process each character in the line. The class updates the AtomicLong variables for each letter and word processed.

- In addition to using multithreading and parallel stream to process each file and character, it's worth noting that this class is thread-safe. This means that multiple threads can safely access and modify the shared state of the FileManager instance without causing data race conditions or other synchronization problems. The use of AtomicLong variables for word and letter counts ensures that these values are modified atomically, i.e. in a single, indivisible operation, making them safe to use in a concurrent environment.

### Conclusion
***
Overall, the FileManager class provides a reliable and efficient way to process files concurrently while ensuring thread safety.