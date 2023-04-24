## Wait-notify file system
Wait-notify & multithread file system for changing the first or last letters to a capital letter depending on the parity of spaces in the text


### Task
***
- Design a two-threaded text file processing system
as follows: The first thread determines the number of spaces in the file if the number
spaces are even - the second thread capitalizes the first letters in the file
of all words, if odd - the last letters. Ensure continuity of file processing
by threads - processing by a second thread of the current file is carried out during processing
the first stream of subsequent files.
- Compare the efficiency of the developed system with the classic multi-threaded one
a system where each thread processes a single file entirely, as well as in cases of processing
files of approximately the same volume and with critically different volumes.

### Setup
***
In your IDE just run the Dispatcher class.
<br/>
The project comes with test files in the two file folders.
if you want to check the system on your files, change the file path in the Dispatcher class or use setFiles method.
### Realization
***
- CustomFile.java: A subclass of the Java File class. It overrides the listFiles method of the File class and provides methods to count the spaces in a file and capitalize the first and last letters of words in a file.
- MultiThreadFileHandler.java: A class that handles multi-threading for each file entirely. It uses the CustomFile class and creates a thread for each file. It also determines if a file has an odd or even number of spaces and applies the corresponding capitalization to its words.
- WaitNotifyFileHandler.java: A class that handles wait-notify threading. It uses the CustomFile class and creates two threads, one for counting the spaces and the other for capitalizing the letters.

The basic idea behind using the wait -notify system is that one thread determines the parity of the sum of spaces in each file independently, while another thread changes to uppercase the first or last letter only after the first thread has determined it.

### Conclusion
***
Wait-notify system can process multiple files in a continuous manner without interruptions or delays. This means that while the first thread processes the current file, the second thread can simultaneously process the subsequent files. This ensures a more efficient use of the available processing resources, reducing the overall processing time.

Moreover, the wait-notify system is particularly effective when processing files of different sizes. In contrast, the classic multi-threaded system processes each file individually, which can lead to delays or overloading when processing large files.

Therefore, the wait-notify system proves to be a more efficient and scalable solution for processing text files.