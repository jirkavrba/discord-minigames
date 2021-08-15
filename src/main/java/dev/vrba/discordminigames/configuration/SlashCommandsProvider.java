package dev.vrba.discordminigames.configuration;

import org.javacord.api.interaction.SlashCommand;

import java.util.List;

/**
 * A common interface for all slash command providers, so it can be easily autowired via the Spring container
 */
@FunctionalInterface
public interface SlashCommandsProvider {

    /**
     * @return a list of all slash commands provided by the given component
     */
    List<SlashCommand> getSlashCommands();

}
