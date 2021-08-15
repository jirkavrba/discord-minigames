package dev.vrba.discordminigames.services;

import dev.vrba.discordminigames.configuration.DiscordConfiguration;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DiscordService {

    private final DiscordApi api;
    
    public DiscordService(DiscordConfiguration configuration) {
        this.api = new DiscordApiBuilder()
                .setToken(configuration.getToken())
                .login()
                .join();
    }

    @Bean
    public DiscordApi discordApi() {
        return this.api;
    }
}
