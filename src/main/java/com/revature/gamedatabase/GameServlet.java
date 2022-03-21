package com.revature.gamedatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameServlet extends HttpServlet
{
    Connection connection;

    {
        try
        {
            connection = DriverManager.getConnection("jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:schema.sql'", "sa", "");
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Game> games = new ArrayList();

        try
        {
            ResultSet resultSet = connection.prepareStatement("select * from com.revature.gamedatabase.Game").executeQuery();

            while (resultSet.next())
            {
                games.add(new Game(resultSet.getInt("GameId"), resultSet.getString("Name")));
            }
        }

        catch (SQLException e)
        {
            e.getMessage();
        }

        ObjectMapper mapper = new ObjectMapper();
        String results = mapper.writeValueAsString(games);
        response.setContentType("application/json");
        response.getWriter().println(results);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        Game newGame = mapper.readValue(request.getInputStream(), Game.class);

        try
        {
            PreparedStatement statement = connection.prepareStatement("insert into 'games' values (?, ?)");

            statement.setInt(1, newGame.getGameId());
            statement.setString(2, newGame.getName());

            statement.executeUpdate();
            statement.close();
        }

        catch (SQLException e)
        {
            e.getMessage();
        }
    }
}
