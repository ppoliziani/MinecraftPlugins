package d_apzi.plugins.commands;

import d_apzi.plugins.Main;
import d_apzi.plugins.tasks.GravityTask;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class G2 implements CommandExecutor {

    private static int check = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
            for (Player p : playerList) {
                if (check % 2 == 0) {
                    p.setGravity(false);
                    check++;
                } else {
                    p.setGravity(true);
                    check++;
                }
            }

        }
        return false;
    }
}