package com.revature.gamedatabase;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

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
