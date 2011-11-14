package org.daragon.demo;

import java.util.List;

 abstract class Base {
	 public abstract void myfunc();

	public void another() {
		System.out.println("Another method"); 
	}
}

public class Derived extends Base {

	public static void main(String argv[]) {
		Derived a = new Derived();
		a.amethod();
	}

	public void myfunc() {
		List l = null;
		System.out.println("My func");
	}

	public void amethod() {
		myfunc();
	}

}
