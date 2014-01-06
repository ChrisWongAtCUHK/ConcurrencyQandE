package oracle.concurrency.guardmeth;

import java.util.Random;

/**
 * @author Chris Wong
 * <p>
 * Producer
 * </p>
 */
public class Producer implements Runnable {
	private String message;
	private boolean empty = true;
	
	/**
	 * Constructor
	 * @param drop
	 */
	public Producer(){
	}
	
	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run(){
		String importantInfo[] = {
				"Mares eat oats",
				"Does eat oats",
				"Little lambs eat ivy",
				"A kid will eat ivy too"
		};
		
		Random random = new Random();
		
		for(int i = 0; i < importantInfo.length; i++){
			while (!empty) {
				try {
					wait();
				} catch (InterruptedException exception) {
					
				}
				
			}
			
			// Toggle status.
			empty = false;
			this.message = importantInfo[i];
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException exception) {
				
			}
		}
		
		this.message = "DONE";
	}
	
	public synchronized String getMessage(){
		while(empty){
			try {
				wait();
			} catch (InterruptedException exception) {
				
			}
		}
		
		// Toggle status.
		empty = true;
		
		// Notify producer that status has changed.
		notifyAll();
		return this.message;
	}
}
