package oracle.concurrency.qande.questions;

public class BadThreads {

	static String message;
	
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
	public static void main(String[] args) throws InterruptedException {
		(new CorrectorThread()).start();
		message = "Mares do not eat oats.";

		Thread.sleep(2000);
		
		// Key statement 2:
		System.out.println(message);

	}

}
