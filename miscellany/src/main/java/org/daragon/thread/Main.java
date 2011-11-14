package org.daragon.thread;

import java.util.Vector;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		// Thread t1 = new Thread(new ThreadTest("t1", 2000));
		// Thread t2 = new Thread(new ThreadTest("t2",2000));
		// Thread t3 = new Thread(new ThreadTest("t3",2000));
		// t1.start();
		// t2.start();
		// t3.start();
		// System.out.print(System.getProperty("java.library.path"));
		Vector vg = new Vector();
//		Thread.sleep(millis)
		vg.add("david1`");
		vg.add("david1`");
			
		Thread b = new B(vg);
		b.start();
		for(int i=1;i<10000111;i++){
			vg.add("david1"+i);
		}
		
	}

}
class B extends Thread {
	Vector vb;
	
	public B(Vector vb) {
		this.vb = vb;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < vb.size(); i++) {
			System.out.println(vb.get(i));
		}
	}
	
}

