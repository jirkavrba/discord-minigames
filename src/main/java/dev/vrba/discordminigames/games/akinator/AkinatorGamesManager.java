package dev.vrba.discordminigames.games.akinator;

import com.markozajc.akiwrapper.Akiwrapper;
import com.markozajc.akiwrapper.AkiwrapperBuilder;
import com.markozajc.akiwrapper.core.exceptions.ServerNotFoundException;
import dev.vrba.discordminigames.games.akinator.entities.AkinatorGame;
import dev.vrba.discordminigames.games.akinator.repositories.AkinatorGamesRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class AkinatorGamesManager {

    private final AkinatorGamesRepository repository;

    private final Map<UUID, Akiwrapper> instances = new HashMap<>();

    public AkinatorGamesManager(AkinatorGamesRepository repository) {
        this.repository = repository;
    }

    public AkinatorGame createGame(long user, long message) throws ServerNotFoundException {
        var game = new AkinatorGame(user, message);
        var instance = new AkiwrapperBuilder().build();

        this.instances.put(game.getId(), instance);

        return this.repository.save(game);
    }

    public Optional<Akiwrapper> getApiWrapperById(UUID id) {
        return Optional.ofNullable(this.instances.get(id));
    }
}
