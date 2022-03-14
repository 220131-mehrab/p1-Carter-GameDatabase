package com.revature.gamedatabase;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

import java.sql.Connection;
import java.sql.DriverManager;

public class App
{
    public static void main(String[] args)
    {
        String webAppName = "";

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(8080);
        server.getConnector();
        server.addContext(webAppName, null);

        server.addServlet(webAppName, "defaultServlet", new DefaultServlet()).addMapping("/*");

        try
        {
            server.start();
            server.getServer().await();
        }

        catch (LifecycleException e)
        {
            e.printStackTrace();
        }
    }
}
