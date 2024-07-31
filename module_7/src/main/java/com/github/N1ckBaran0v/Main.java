package com.github.N1ckBaran0v;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server(5050);
        server.start();
        System.out.println("Server started");
        server.join();
    }
}