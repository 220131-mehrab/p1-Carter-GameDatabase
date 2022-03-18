package com.revature.gamedatabase;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService
{
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository)
    {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames()
    {
        return gameRepository.getAll();
    }

    public Game getGame(int id)
    {
        return gameRepository.getGame(id);
    }
}
