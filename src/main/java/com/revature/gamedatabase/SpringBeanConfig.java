package com.revature.gamedatabase;

import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class SpringBeanConfig
{
    @Bean
    public Tomcat tomcat()
    {
        Tomcat server = new Tomcat();
        server.setBaseDir(new File(System.getProperty("java.io.tmpdir")).getAbsolutePath());
        server.setPort(8080);
        server.getConnector();
        server.addContext("", null);
        return server;
    }
}
