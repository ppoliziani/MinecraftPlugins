package d_apzi.plugins.runner.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Runner implements CommandExecutor {

    private List<Player> runnerList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                Player runner = Bukkit.getPlayerExact(args[0]);
                if (runner instanceof Player) {
                    if (!runnerList.contains(runner)) {
                        runnerList.add(runner);
                        player.getServer().broadcastMessage(ChatColor.BLUE + runner.getDisplayName() + " is now the runner");
                        runner.sendMessage("You have to evade the assassin, you can stare at them to freeze them " +
                                "but if they hit you once they die! Good luck!");
                        runner.setWalkSpeed(1);
                    } else {
                        runnerList.remove(runner);
                        player.getServer().broadcastMessage(ChatColor.BLUE + runner.getDisplayName() + " is no longer the runner");
                        runner.sendMessage("You are no longer the runner");
                        runner.setWalkSpeed((float) 0.2);
                    }
                }
            } else {
                player.sendMessage("Need to specify a player name");
            }
        }
        return false;
    }
}
