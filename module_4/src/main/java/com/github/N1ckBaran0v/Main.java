package com.github.N1ckBaran0v;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.log.Log;

public class Main {
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new WebSocketChatServlet()), "/chat");
        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        Log.getLog().info("Server started");
        server.join();
    }
}