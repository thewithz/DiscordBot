package events.commands.music;

import bots.RunBot;
import events.commands.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.util.Collections;
import java.util.List;

/**
 * Created by TheWithz on 4/24/16.
 */
public class StopCommand extends Command {
    @Override
    public void onCommand(MessageReceivedEvent event, String[] args) {
        AudioUtil.player.stop();
        event.getChannel().sendMessageAsync(":white_check_mark: playback has been completely stopped.", null);
    }

    @Override
    public java.util.List<String> getAliases() {
        return Collections.singletonList(RunBot.PREFIX + "stop");
    }

    @Override
    public String getDescription() {
        return "Stops the audio player completely.";
    }

    @Override
    public String getName() {
        return "Stop Command";
    }

    @Override
    public java.util.List<String> getUsageInstructionsEveryone() {
        return Collections.singletonList(String.format("(%1$s)]\n" +
                                                               "[Example:](%1$s) Stops <%2$s's> audio player", getAliases().get(0), RunBot.BOT.getUsername()));
    }

    @Override
    public List<String> getUsageInstructionsOp() {
        return getUsageInstructionsEveryone();
    }

    @Override
    public List<String> getUsageInstructionsOwner() {
        return getUsageInstructionsEveryone();
    }
}

