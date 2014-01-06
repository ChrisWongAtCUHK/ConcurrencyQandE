package oracle.concurrency.qande.questions;

public class BadThreads {

	static String message;
	private static Object lock = new Object();
	
	private static class CorrectorThread extends Thread {
		@Override
		public void run(){
			try {
				sleep(1000);
			} catch (InterruptedException excpetion){}
			// Key statement1:
			synchronized(lock){
				message = "Mares do eat oats.";
			}
		}
	}
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		(new CorrectorThread()).start();
		synchronized(lock){
			message = "Mares do not eat oats.";
		}
		
		Thread.sleep(2000);
		// Key statement 2:
		
		synchronized(lock){
			System.out.println(message);
		}

	}

}
