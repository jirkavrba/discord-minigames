package dev.vrba.discordminigames.games.akinator.repositories;

import dev.vrba.discordminigames.games.akinator.entities.AkinatorGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AkinatorGamesRepository extends CrudRepository<AkinatorGame, UUID > {
}
