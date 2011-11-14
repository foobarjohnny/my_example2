package org.daragon.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NetworkService implements Runnable {
    
    private final ServerSocket serverSocket;
    private final ExecutorService pool;
    
    public NetworkService(int port,int poolSize) throws IOException {
        
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown();
        
        try {
            if(!pool.awaitTermination(60, TimeUnit.SECONDS)){
                pool.shutdownNow();
                if(!pool.awaitTermination(60, TimeUnit.SECONDS)){
                    System.out.println("Failed to shutdown..");
                }
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
        
    }

    public void run() {
        for(;;){
            try {
                pool.execute(new Handler(serverSocket.accept()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class Handler implements Runnable{
        private final Socket socket;
        public Handler(Socket socket) {
            super();
            this.socket = socket;
        }

        public void run() {
            //TODO read and service request on socket
        }
        
    }
    
}
