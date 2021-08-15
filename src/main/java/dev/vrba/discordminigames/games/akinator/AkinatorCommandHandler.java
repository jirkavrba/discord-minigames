package dev.vrba.discordminigames.games.akinator;

import org.javacord.api.entity.message.Message;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;
import org.springframework.stereotype.Component;

@Component
public class AkinatorCommandHandler implements SlashCommandCreateListener {

    private final AkinatorGamesManager manager;

    public AkinatorCommandHandler(AkinatorGamesManager manager) {
        this.manager = manager;
    }

    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        if (!shouldHandle(event)) {
            return;
        }

        event.getInteraction().respondLater().join();

        Message message = event.getInteraction()
                .createFollowupMessageBuilder()
                .addEmbed(AkinatorEmbedBuilders.creatingNewGameEmbed())
                .send()
                .join();
    }

    private boolean shouldHandle(SlashCommandCreateEvent event) {
        return !event.getInteraction().getUser().isBot() &&
                // TODO: Should this bot support DMs?
               event.getInteraction().getServer().isPresent() &&
               event.getSlashCommandInteraction().getCommandName().equalsIgnoreCase("akinator");
    }

}
