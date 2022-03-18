package com.revature.gamedatabase;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

public class App
{
    public static void main(String[] args)
    {
        Tomcat server = new Tomcat();
        server.setBaseDir("java.io.tmpdir");
        server.setPort(8080);
        server.getConnector();
        server.addContext("", null);

        server.addServlet("", "DefaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("", "GameServlet", new GameServlet()).addMapping("/games");
        server.addServlet("", "AddGameServlet", new AddGame()).addMapping("/addgame");

        try
        {
            server.start();
        }

        catch (LifecycleException e)
        {
            e.printStackTrace();
        }
    }
}
