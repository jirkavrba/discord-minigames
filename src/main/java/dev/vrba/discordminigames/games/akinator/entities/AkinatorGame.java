package dev.vrba.discordminigames.games.akinator.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AkinatorGame {
    @Id
    private final UUID id = UUID.randomUUID();

    // ID of the User who created the game
    private long user;

    // ID of the message where the game is being played
    private long message;
}
