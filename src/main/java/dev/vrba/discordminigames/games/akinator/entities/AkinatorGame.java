package dev.vrba.discordminigames.games.akinator.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AkinatorGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final UUID id = UUID.randomUUID();

    // ID of the User who created the game
    public long user;

    // ID of the message where the game is being played
    public long message;
}
