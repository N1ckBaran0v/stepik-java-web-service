package com.github.N1ckBaran0v;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketThread extends Thread {
    private final Socket socket;
    private static final int BUFFER_SIZE = 64;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            while (true) {
                int count = inputStream.read(buffer);
                if (count == -1) {
                    sleep(500);
                } else if (count == 4 && buffer[0] == 'B' && buffer[1] == 'u' && buffer[2] == 'e' && buffer[3] == '.') {
                    socket.close();
                    break;
                } else {
                    outputStream.write(buffer, 0, count);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
