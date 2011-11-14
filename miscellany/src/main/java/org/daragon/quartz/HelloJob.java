package org.daragon.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		System.err.println("that is the first test");
	}

}
