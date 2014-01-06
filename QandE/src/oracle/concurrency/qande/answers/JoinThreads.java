package oracle.concurrency.qande.answers;

/**
 * <p>
 *  JoinThreads 
 * </p>
 * @author Chris Wong
 *
 */
public class JoinThreads {
	static String message;
	
	/**
	 * <p>
	 *  CorrectorThread is a thread subclass
	 * </p>
	 * @author Chris Wong
	 *
	 */
	private static class CorrectorThread extends Thread {
		@Override
		public void run(){
			try {
				sleep(1000);
			} catch (InterruptedException excpetion){}
			// Key statement1:
			message = "Mares do eat oats.";

		}
	}
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException  {
		CorrectorThread correctorThread = new CorrectorThread();
		correctorThread.start();
		message = "Mares do not eat oats.";

		Thread.sleep(2000);
		// Key statement 2:

		correctorThread.join();
		System.out.println(message);

	}

}
