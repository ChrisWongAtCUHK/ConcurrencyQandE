package oracle.concurrency.guardmeth;

import java.util.Random;
import static java.lang.System.out;

/**
 * @author Chris Wong
 * <p>
 *  Consumer
 * </p>
 */
public class Consumer implements Runnable {
	private Producer producer;
	/**
	 * Constructor
	 * @param Producer producer
	 */
	public Consumer(Producer producer){
		this.producer = producer;
	}
	
	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run(){
		Random random = new Random();
		for(String message = this.producer.getMessage(); !message.equals("DONE"); message = this.producer.getMessage()){
			out.format("MESSAGE RECEIVED: %s%n", message);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException exception) {
				
			}
		}
	}

}
