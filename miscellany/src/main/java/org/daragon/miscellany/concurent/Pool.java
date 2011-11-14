package org.daragon.miscellany.concurent;

import java.util.concurrent.Semaphore;

public class Pool {

	private static final int MAX_AVAILABLE = 100;
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

	private Object[] items;
	protected boolean[] used = new boolean[MAX_AVAILABLE];

	public Object getItem() throws InterruptedException {
		available.acquire();
		return null;
	}

	public void putItem(Object x) {

	}

	protected synchronized Object getNextAvailableItem() {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				used[i] = true;
				return items[i];
			}
		}
		return null; // not reached
	}

	protected synchronized boolean markAsUnused(Object item) {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (item == items[i]) {
				if (used[i]) {
					used[i] = false;
					return true;
				} else
					return false;
			}
		}
		return false;
	}

}
