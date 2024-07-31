package com.github.N1ckBaran0v;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Thread implements Runnable {
    private static final int THREADS_COUNT = 10;
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; ++i) {
            try {
                threads[i] = new SocketThread(serverSocket.accept());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < THREADS_COUNT; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
