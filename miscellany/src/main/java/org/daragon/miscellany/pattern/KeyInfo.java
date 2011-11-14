package org.daragon.miscellany.pattern;

public class KeyInfo {
    private int keyMax;
    private int keyMin;
    private int nextKey;
    private int poolSize;

    public KeyInfo(int poolSize) {
        this.poolSize = poolSize;
    }

    public int getNextKey() {
        if(nextKey>keyMax){
            retrieveFromDB();
        }
        
        return nextKey++;
    }

    private void retrieveFromDB() {
        String sql1 = "update keytable set keyvalue=keyvalue+"+poolSize+" where keyname='po_number'";
        String sql2 = "select keyvalue from keytable where keyname='po_number'";
        //
        int keyFromDB = 1000;
        keyMax = keyFromDB;
        keyMin = keyFromDB-poolSize+1;
        nextKey = keyMin;
    }

    public int getKeyMax() {
        return keyMax;
    }

    public int getKeyMin() {
        return keyMin;
    }

}
