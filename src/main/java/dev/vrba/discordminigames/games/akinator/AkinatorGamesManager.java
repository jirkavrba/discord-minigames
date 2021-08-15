package dev.vrba.discordminigames.games.akinator;

import dev.vrba.discordminigames.games.akinator.entities.AkinatorGame;
import dev.vrba.discordminigames.games.akinator.repositories.AkinatorGamesRepository;
import org.springframework.stereotype.Component;

@Component
public class AkinatorGamesManager {

    private final AkinatorGamesRepository repository;

    public AkinatorGamesManager(AkinatorGamesRepository repository) {
        this.repository = repository;
    }

    public AkinatorGame createGame(long user, long message) {
        var game = new AkinatorGame(user, message);

        // TODO: create an akinator wrapper and assign it to the repository ID
        return this.repository.save(game);
    }
}
