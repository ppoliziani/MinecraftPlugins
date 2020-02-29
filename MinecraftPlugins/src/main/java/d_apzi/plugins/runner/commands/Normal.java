package d_apzi.plugins.runner.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Normal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("You are now at full health");
            player.setHealth(player.getHealth() + (20 - player.getHealth()));
            player.setWalkSpeed((float) 0.2);
        }
        return false;
    }
}
