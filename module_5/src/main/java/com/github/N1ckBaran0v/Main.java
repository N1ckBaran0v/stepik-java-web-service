package com.github.N1ckBaran0v;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.log.Log;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        AccountServerInterface service = new AccountServer();
        AccountServerControllerMBean serverControllerMBean = new AccountServerController(service);
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ServerManager:type=AccountServerController");
        mBeanServer.registerMBean(serverControllerMBean, name);
        context.addServlet(new ServletHolder(new AdminServlet(service)), "/admin");
        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        Log.getLog().info("Server started");
        server.join();
    }
}