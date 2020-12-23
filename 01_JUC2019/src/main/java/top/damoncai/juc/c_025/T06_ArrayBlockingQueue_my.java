package top.damoncai.juc.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue_my {

	static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

	static Random r = new Random();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0 ; i < 2 ; i++) {
			int finalI = i;
			new Thread(() -> {
				int j = finalI;
				while (true) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					String str = r.nextDouble() + "";
					try {
						strs.put(str);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("P" + j +" £º"  + str);
				}
			}, "p").start();
		}

//		for (int i = 0 ; i < 2 ; i++) {
//			int finalI = i;
//			new Thread(() -> {
//				int j = finalI;
//				while (true) {
//					try {
//						TimeUnit.SECONDS.sleep(1);
//						String str = strs.take();
//						System.out.println("C" + j +" £º" + str);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			},"C" + i).start();
//		}
	}
}
