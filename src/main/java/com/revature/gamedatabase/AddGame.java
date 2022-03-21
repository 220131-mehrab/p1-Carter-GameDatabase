package com.revature.gamedatabase;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class AddGame extends HttpServlet
{
    public AddGame(){}

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        InputStream fileName = getClass().getClassLoader().getResourceAsStream("static/addGame.html");
        IOUtils.copy(fileName, response.getOutputStream());
    }
}
