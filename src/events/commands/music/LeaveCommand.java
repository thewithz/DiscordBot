package events.commands.music;

import bots.RunBot;
import events.commands.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.util.Arrays;

/**
 * Created by TheWithz on 4/24/16.
 */
public class LeaveCommand extends Command {
    //Disconnect the audio connection with the VoiceChannel.
    @Override
    public void onCommand(MessageReceivedEvent event, String[] args) {
        AudioUtil.manager.closeAudioConnection();
    }

    @Override
    public java.util.List<String> getAliases() {
        return Arrays.asList(RunBot.prefix + "leave");
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public java.util.List<String> getUsageInstructions() {
        return null;
    }
}
