package com.revature.gamedatabase;

import com.revature.gamedatabase.SpringBeanConfig;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class App
{
    public static void main(String[] args)
    {
        ApplicationContext springIoC = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        AnnotationConfigWebApplicationContext webmvc = new AnnotationConfigWebApplicationContext();
        webmvc.setParent(springIoC);
        webmvc.scan("com.revature.gamedatabase");

        Tomcat server = springIoC.getBean(Tomcat.class);

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
