package dev.vrba.discordminigames.services;

import dev.vrba.discordminigames.configuration.DiscordConfiguration;
import dev.vrba.discordminigames.configuration.SlashCommandsProvider;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.listener.GloballyAttachableListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscordService {

    private final DiscordApi api;

    private final Environment environment;

    private final DiscordConfiguration configuration;

    private final List<GloballyAttachableListener> listeners;

    private final List<SlashCommandsProvider> providers;

    public DiscordService(
            Environment environment,
            DiscordConfiguration configuration,
            List<GloballyAttachableListener> listeners,
            List<SlashCommandsProvider> providers
    ) {
        this.api = new DiscordApiBuilder()
                .setToken(configuration.getToken())
                .login()
                .join();

        this.environment = environment;
        this.configuration = configuration;
        this.listeners = listeners;
        this.providers = providers;
    }

    public void start() {
        // Register all event listeners
        listeners.forEach(this.api::addListener);

        // All commands, defined by all providers available to the application container
        var commands = providers.stream()
                .map(SlashCommandsProvider::getSlashCommands)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // If running in development mode, register all slash commands guild-only
        // (otherwise there is up to 1-hour delay from Discord, when registering the command globally)
        if (environment.acceptsProfiles(Profiles.of("development"))) {
            // Test server, as defined by the configuration
            Server testServer = this.api
                    .getServerById(configuration.getTestGuildId())
                    .orElseThrow(() -> new IllegalArgumentException("Cannot find the configured test guild by its ID!"));

            commands.forEach(command -> command.createForServer(testServer));
        }
        // If running in the production, register all commands globally instead
        else {
            commands.forEach(command -> command.createGlobal(this.api));
        }
    }

    @Bean
    public DiscordApi discordApi() {
        return this.api;
    }
}
