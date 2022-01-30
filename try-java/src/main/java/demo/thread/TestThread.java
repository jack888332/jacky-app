package demo.thread;

public class TestThread {

	public static void main(String[] args) {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 10; i++) {
//					System.out.println(Thread.currentThread().getName() + ":" + i);
//				}
//			}
//		}).start();

		CommonDataHandler cdh = new CommonDataHandler();

		Thread thread1 = new Thread(cdh);
		Thread thread2 = new Thread(cdh);
		Thread thread3 = new Thread(cdh);

		thread1.start();
		thread2.start();
		thread3.start();

//		for (int i = 0; i < 10; i++) {
//			System.out.println(Thread.currentThread().getName() + ":" + i);
//		}
	}

}

class CommonDataHandler implements Runnable {
	private int ticket = 10; //多线程访问的公共数据

	@Override
	public void run() {
		while (true) {
			if (ticket > 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":正在卖第" + ticket + "张票");
				ticket--;
			} else {
				break;
			}
		}
	}
}
