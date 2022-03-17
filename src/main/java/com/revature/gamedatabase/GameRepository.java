package com.revature.gamedatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepository
{
    @Autowired
    private DataSource dataSource;

    public GameRepository(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public List<Game> getAll()
    {
        List<Game> games = new ArrayList<>();

        try
        {
            Connection connection = dataSource.getConnection();
            ResultSet rs = connection.prepareStatement("select * from game").executeQuery();

            while (rs.next())
            {
                games.add(new Game(rs.getInt("game_id"), rs.getString("name")));
            }
        }

        catch (SQLException e)
        {
            System.err.println("Failed to retrieve from database: " + e.getMessage());
        }

        return games;
    }

    public Game getGame(int id)
    {
        Game game = new Game();

        try
        {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from game where game_id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                game = new Game(rs.getInt("game_id"), rs.getString("name"));
            }
        }

        catch (SQLException e)
        {
            System.err.println("Failed to retrieve game: " + e.getMessage());
        }

        return game;
    }
}
