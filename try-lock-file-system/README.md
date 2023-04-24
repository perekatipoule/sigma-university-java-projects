## Try-lock file system
A try-lock & multithread file systems for summing numbers in text files


### Task
***
Using the resources of the package
java.util.concurrent.locks to create a synchronous multithreading system to define
total sum of all numbers in three text files. In case of thread blocking,
it should display its name with the stamp “LOCKED”. DO NOT USE
intermediate creation of collections for read text.

### Setup
***
In your IDE just run the Dispatcher class.
<br/>
The project comes with test files in the "files" folder.
if you want to check the system on your files, change the file path in the Dispatcher class.
### Realization
***
The program initializes the files, a regular expression pattern, and a lock object. It then creates three threads to read the numbers from each file and add them to a shared NumberAdder object. The NumberAdder object uses a long variable to store the total sum of the numbers.<br/>
<br/>
Each thread is an instance of the NumberCounter class, which implements the Runnable interface. The NumberCounter constructor takes in a name, a NumberAdder object, a File object, a Pattern object, and a Lock object. The run method of the NumberCounter class reads the numbers from the file using a BufferedReader object and a regular expression matcher. It then calls the addOrLock method to add the number to the NumberAdder object using a lock mechanism. The addOrLock method attempts to acquire the lock and adds the number to the NumberAdder object if successful. If the lock is not available, the thread prints a message to indicate that it is waiting to acquire the lock. 
<br/>

### Conclusion
***
Overall, this project demonstrates how to use a lock mechanism to perform useful work (in this example it is printing of thread name with note "LOCKED", but you can do all that is necessary instead) during locking thread while prevent data races in a multithreaded program that accesses shared data. 
