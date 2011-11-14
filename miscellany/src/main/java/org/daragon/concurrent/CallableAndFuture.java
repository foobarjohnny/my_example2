package org.daragon.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {
	/**
	 * 
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		ExecutorService es = Executors.newSingleThreadExecutor();

		ExecutorService es2 = Executors.newCachedThreadPool();
		Future<String> future = es.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(5000);
				return "demo and test";
			}
		});

		System.out.println("Task submited");
		System.out.println(future.get());

		Future<String> future2 = es.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "demo2";
			}
		});

		System.out.println("task 2 submit");
		System.out.println(future2.get());

		// es.shutdown();

		CompletionService<String> cs = new ExecutorCompletionService<String>(
				es2);
		for (int i = 0; i < 10; i++) {
			final Integer seq = i + 1;
			cs.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					Thread.sleep((long) (Math.random() * 1000));
					return String.valueOf(seq);
				}
			});
		}

		for (int i = 0; i < 10; i++) {
			Future<String> f = cs.take();
			System.out.println(f.get());

		}

	}
}
