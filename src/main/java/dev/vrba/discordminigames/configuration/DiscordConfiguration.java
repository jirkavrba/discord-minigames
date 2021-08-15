package dev.vrba.discordminigames.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "discord")
public class DiscordConfiguration {

    /**
     * Discord token used for Discord gateway authentication
     */
    private String token;

    /**
     * ID of the guild used for testing the bot
     */
    private long testGuildId;
}
