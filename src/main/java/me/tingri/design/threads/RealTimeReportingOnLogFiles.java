package me.tingri.design.threads;

/**
 * 
 * ip log... millions of rows/minute
 * ip address, session items, userid, content marker (integer 1 -100)
 * 
 * Without group by every minute, what’s the top ten ip address coming in and top ten content markers
Objects
	Threads
Main
LogWriter
		LogReader
		ReportGenerator
	
* Main thread will kick start LogWriter which is assumed to continuously write to logs …
* Main thread will contain a global Queue which contains one record per minute with intermediate results
* Main Thread will kick start LogReader which will keep track of time and for every 60s add a node to the global Queue, 
* the value inside the queue would be a custom Node containing 
an int[100] which contains the number of records containing a specific marker i at the array location i
* Main Thread will kickstart ReportGenerator which will take iterms out of the queue and report on the top ten
 * 
 * @author kunkunur
 *
 */
public class RealTimeReportingOnLogFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}






/*public class Node {
	private int[] countOfMarkers = new int[100];

	pubic void setCountOfMarkers(int[] count)

	public int[] getCount
	

}


public class LogReader implements Runnable {
	private File log;
	private Queue queue;
	public LogReader(File logFile, Queue globalQueue){
		log = logFile;
		queue =globalQueue;
}
	
	public void start(){
		BufferedFileReader bfr = new BufferedFileReader(new FileReader(log));
		long startTime = System.getTimeInMilliseconds();
int[] count;
		
while(true) {
if(count == null) {
	   count = new int[100];
}
			
String line = bfr.readLine();

if(line == null) {
	sleep(10);
}

Sttring[] line = line.split(“,”); 

//ip address, session items, userid, content marker (integer 1 -100)

			count[line[3]] = count[line[3]] + 1; 
			
			if (System.getTimeInMilliSeconds() - startTime > 60 * 1000) {
		Node node = new Node();

		node.setCount(count);

queue.enqueue(node);
		
count = null; 
startTime = System.getTimeInMilliSeconds();

	}
	
}
}
}


public class ReportGenerator implements Runnable {
	private Queue queue;
	public LogReader(Queue globalQueue){
		queue =globalQueue;
}
	
	public void start(){
		BufferedFileReader bfr = new BufferedFileReader(new FileReader(log));
		long startTime = System.getTimeInMilliseconds();
		
while(true) {
Node node = queue.dequeue();


if(node == null) {
	sleep(10);
}



			for( int i = 1:100) {
innerloop: for int j = 1:10 {
if(count(top[j]) > count[i]]){
	continue;
else {
for int k = j+1:10{
			top[k] = top[k-1];
		}

top[j] = i;
		break innerloop;
	}
}
	}
}
}
}
*/
