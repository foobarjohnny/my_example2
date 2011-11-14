package org.daragon.thread;

public class YieldTest {
	public static void main(String[] args) {
		/**
		 * 3.yield()使线程放弃执行的权利，进入可执行状态，也就意味着线程在yield()方法后，有可能又执行。使用yield()方法，
		 * 线程并不释放自己锁持有的“锁”。
		 */
		Thread.currentThread().yield();

		
		
		
	}
}
