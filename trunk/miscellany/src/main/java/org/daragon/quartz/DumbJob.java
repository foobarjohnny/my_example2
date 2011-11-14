package org.daragon.quartz;

import java.util.ArrayList;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class DumbJob implements Job {
	String jobSays;
	float myFloatValue;
	ArrayList state;

	public DumbJob() {
	}

	public String getJobSays() {
		return jobSays;
	}

	public void setJobSays(String jobSays) {
		this.jobSays = jobSays;
	}

	public float getMyFloatValue() {
		return myFloatValue;
	}

	public void setMyFloatValue(float myFloatValue) {
		this.myFloatValue = myFloatValue;
	}

	public ArrayList getState() {
		return state;
	}

	public void setState(ArrayList state) {
		this.state = state;
	}

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		JobKey key = context.getJobDetail().getKey();
		JobDataMap dataMap = context.getMergedJobDataMap();

		System.out.println("Instance " + key + " of DumbJob says: " + jobSays
				+ ",and val is:" + myFloatValue);

	}

}
