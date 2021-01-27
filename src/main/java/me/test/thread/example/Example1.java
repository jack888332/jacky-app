package me.test.thread.example;

public class Example1 {

	public static void main(String[] args) {
		Object monitor1 = new Object();

		new Thread(() -> {
			while (true) {
				synchronized (monitor1) {
					System.out.println("----------------------");
					System.out.println("【" + Thread.currentThread().getName() + "】吃货：我要一碗白饭");
					try {
						monitor1.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("【" + Thread.currentThread().getName() + "】吃货：白饭真香，开吃");
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("火火火");
					synchronized (monitor1) {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("【" + Thread.currentThread().getName() + "】厨师：白饭已经做好了");
						monitor1.notify();
					}
				}
			}
		}).start();

//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while (true) {				
//					synchronized (monitor1) {
//						try {
//							Thread.sleep(3000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}						
//						System.out.println("【" + Thread.currentThread().getName() + "】厨师：白饭已经做好了");
//						monitor1.notify();
//					}
//				}
//			}
//		}).start();
	}

}
