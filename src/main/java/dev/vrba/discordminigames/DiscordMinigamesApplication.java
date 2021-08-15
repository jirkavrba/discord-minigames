package dev.vrba.discordminigames;

import dev.vrba.discordminigames.services.DiscordService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscordMinigamesApplication implements CommandLineRunner {

    private final DiscordService service;

    public DiscordMinigamesApplication(DiscordService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        this.service.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(DiscordMinigamesApplication.class, args);
    }
}
