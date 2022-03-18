package com.revature.gamedatabase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class AddGame
{
    public AddGame(){}

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
    {
        InputStream fileName = getClass().getClassLoader().getResourceAsStream("static/addGame.html");

        try
        {
            IOUtils.copy(fileName, response.getOutputStream());
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
