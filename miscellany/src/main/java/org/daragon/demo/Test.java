package org.daragon.demo;




public  class Test {
    enum Status {
        START_PENDING("START_PENDING"), 
        STARTING("STARTING"),
        RUNNING("RUNNING"), 
        STOP_PENDING("STOP_PENDING"),
        STOPPED("STOPPED"), 
        PAUSE_PENDING("PAUSE_PENDING"), 
        PAUSED("PAUSED"),
        RESUME_PENDING("RESUME_PENDING");

        private String text;

        private Status(String text) {
            this.text = text;
        }
    }
	
	public static void main(String[] args)  {

	   System.out.println(Status.PAUSE_PENDING.ordinal()); ;
	}
}
