package org.daragon.thread;

public class TryThread extends Thread {

    private String firstName;
    private String lastName;

    private long    delay;

    public TryThread(String firstName, String lastName, long l) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.delay = l;
        setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println(firstName);
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            System.out.println(firstName + lastName + e);
        }

        System.out.println(lastName);
    }

}
