package demo;

public class ThreadDemo {

	public static void main(String[] args) {
		CustomThread ct = new CustomThread(0);
		ct.start();
		synchronized(ct) {
			try {
				ct.wait();
			} catch (InterruptedException ex) {
				
			}
		}
		
		//new Thread(new CustomRunnable()).start();

//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Anonymous Runnable");
//			}
//		}).start();
//
//		new Thread(() -> System.out.println("Lambda Runnable")).start();
	}

}

class CustomThread extends Thread {
	private int counter;

	public CustomThread(int counter) {
		super();
		this.counter = counter;
	}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 25; i++)
				System.out.println("Custom Thread " + counter++);
		}
	}
}

class CustomRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 25; i++)
			System.out.println("Custom Runnable");
	}

}