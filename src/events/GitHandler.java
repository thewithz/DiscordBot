package events;

import bots.RunBot;
import net.dv8tion.jda.entities.TextChannel;
import net.dv8tion.jda.hooks.ListenerAdapter;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by thewithz on 7/6/16.
 */
public class GitHandler extends ListenerAdapter {
    private static GitHub github;
    private static Timer timer = new Timer();
    private static Date lastCommit;
    private static GHRepository discordRepo;

    public GitHandler(String gitApiToken, String gitUserName) {
        try {
            github = new GitHubBuilder().withOAuthToken(gitApiToken, gitUserName).build();
            discordRepo = github.getMyself().getRepository("DiscordBot");id
            lastCommit = discordRepo.getPushedAt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void startTimer() {
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println(discordRepo.getPushedAt() + " : " + lastCommit);
                if (!discordRepo.getPushedAt().equals(lastCommit)) {
                    TextChannel textChannel = RunBot.API.getTextChannelById("147169039049949184");
                    textChannel.sendMessageAsync(":white_check_mark: a new Commit has been pushed to DiscordBot", null);
                    lastCommit = discordRepo.getPushedAt();
                }
            }
        }, 0, 10 * 1000);
    }
}