package oracle.concurrency.qande.answers.guardmeth;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * <p>
 *  <a href="http://docs.oracle.com/javase/tutorial/essential/concurrency/QandE/answers.html">ProducerConsumerExample</a>
 * </p>
 * @author oracle
 *
 */
public class ProducerConsumerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 BlockingQueue<String> drop =
		            new SynchronousQueue<String> ();
		        (new Thread(new Producer(drop))).start();
		        (new Thread(new Consumer(drop))).start();

	}

}
