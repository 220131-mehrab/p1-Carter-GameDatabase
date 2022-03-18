package com.revature.gamedatabase;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost", maxAge = 3600)
public class GameController
{
    private GameService gameService;

    public GameController(GameService gameService)
    {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<Game> getGames()
    {
        return gameService.getAllGames();
    }

    @GetMapping("/games/{id}")
    public Game getGame(@PathVariable("id") int id)
    {
        return gameService.getGame(id);
    }

    @PostMapping("/games")
    public void postGame(Game game){}
}
