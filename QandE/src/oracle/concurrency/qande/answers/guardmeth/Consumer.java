package oracle.concurrency.qande.answers.guardmeth;

import static java.lang.System.out;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * <p>
 *  Consumer consumes products produced by produces
 * </p>
 * @author oracle
 *
 */
public class Consumer implements Runnable {
	private BlockingQueue<String> drop;
	
	/**
	 * Constructor
	 * @param drop blocking queue of String
	 */
	public Consumer(BlockingQueue<String> drop){
		this.drop = drop;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		
		try{
			for(String message = drop.take(); !message.equals("DONE"); message = drop.take()){
				out.format("MESSAGE RECEIVED: %s%n", message);
				
				Thread.sleep(random.nextInt(5000));
			}
		} catch (InterruptedException e) {}
	}
	

}
