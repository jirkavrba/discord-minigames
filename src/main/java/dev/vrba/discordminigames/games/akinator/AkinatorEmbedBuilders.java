package dev.vrba.discordminigames.games.akinator;

import com.markozajc.akiwrapper.Akiwrapper;
import com.markozajc.akiwrapper.core.entities.Question;
import dev.vrba.discordminigames.utilities.DiscordColors;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AkinatorEmbedBuilders {

    public static final List<Pair<String, Akiwrapper.Answer>> reactionEmojis = List.of(
            Pair.of("\uD83D\uDC4D", Akiwrapper.Answer.YES),
            Pair.of("\uD83D\uDE42", Akiwrapper.Answer.PROBABLY),
            Pair.of("\uD83D\uDE15", Akiwrapper.Answer.DONT_KNOW),
            Pair.of("\uD83D\uDE43", Akiwrapper.Answer.PROBABLY_NOT),
            Pair.of("\uD83D\uDC4E", Akiwrapper.Answer.NO)
    );

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
        var emojis = reactionEmojis.stream()
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
