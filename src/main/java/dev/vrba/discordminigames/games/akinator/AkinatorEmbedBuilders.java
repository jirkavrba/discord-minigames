package dev.vrba.discordminigames.games.akinator;

import com.markozajc.akiwrapper.Akiwrapper;
import com.markozajc.akiwrapper.core.entities.Question;
import dev.vrba.discordminigames.utilities.DiscordColors;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.util.Locale;
import java.util.stream.Collectors;

import static dev.vrba.discordminigames.games.akinator.AkinatorCommandHandler.REACTION_EMOJIS;

public class AkinatorEmbedBuilders {

    public static EmbedBuilder creatingNewGameEmbed() {
        return new EmbedBuilder()
                .setTitle("Discord minigames")
                .setDescription("Creating a new Akinator game...")
                .setColor(DiscordColors.Green);
    }

    public static EmbedBuilder serverNotFoundException() {
        return new EmbedBuilder()
                .setTitle("Error")
                .setDescription("Akinator server not found.")
                .setColor(DiscordColors.Red);
    }

    public static EmbedBuilder missingApiInstance() {
        return new EmbedBuilder()
                .setTitle("Error")
                .setDescription("Missing Akinator API instance.")
                .setColor(DiscordColors.Red);
    }

    public static EmbedBuilder createQuestionMessage(Question question) {
        var emojis = REACTION_EMOJIS.stream()
                .map(pair -> String.format("%s - %s",
                        pair.getFirst(),
                        pair.getSecond().toString()
                                .toLowerCase(Locale.ROOT)
                                .replaceAll("_", " ")
                ))
                .collect(Collectors.joining("\n"));

        return new EmbedBuilder()
                .setTitle(question.getQuestion())
                .setDescription(emojis)
                .setColor(DiscordColors.Primary);
    }
}
