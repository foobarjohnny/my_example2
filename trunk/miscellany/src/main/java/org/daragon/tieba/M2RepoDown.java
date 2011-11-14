package org.daragon.tieba;

public class M2RepoDown {
    private static final long MILLISECONDS_PER_DAY = 1000L*24*60*60;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        
        long day = time / MILLISECONDS_PER_DAY;
        long timeOfDay = time - (day * MILLISECONDS_PER_DAY);
        System.out.println(timeOfDay);
        System.out.println(time);

    }
}
