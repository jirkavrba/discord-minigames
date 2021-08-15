package dev.vrba.discordminigames.games.akinator;

import dev.vrba.discordminigames.configuration.SlashCommandsProvider;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AkinatorCommandsProvider implements SlashCommandsProvider {

    @Override
    public List<SlashCommandBuilder> getSlashCommands() {
        return List.of(
                SlashCommand
                        .with("akinator", "Creates a new Akinator game instance.")
                        .setDefaultPermission(true)
        );
    }
}
