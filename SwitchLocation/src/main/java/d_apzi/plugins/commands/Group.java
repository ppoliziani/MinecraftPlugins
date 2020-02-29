package d_apzi.plugins.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Group implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
            for (Player p : playerList) {
                p.teleport(player.getLocation());
            }
        }
        return false;
    }
}
