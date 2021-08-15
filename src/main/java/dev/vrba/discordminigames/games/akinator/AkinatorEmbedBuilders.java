package dev.vrba.discordminigames.games.akinator;

import dev.vrba.discordminigames.utilities.DiscordColors;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public class AkinatorEmbedBuilders {

    public static EmbedBuilder creatingNewGameEmbed() {
        return new EmbedBuilder()
                .setTitle("Discord minigames")
                .setDescription("Creating a new Akinator game...")
                .setColor(DiscordColors.Green);
    }
}
