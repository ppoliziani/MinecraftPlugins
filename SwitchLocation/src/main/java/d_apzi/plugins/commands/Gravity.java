package d_apzi.plugins.commands;

import d_apzi.plugins.Main;
import d_apzi.plugins.tasks.GravityTask;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class Gravity implements CommandExecutor {

    private BukkitTask gravitytask = null;
    private final Main plugin;

    public Gravity(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (this.gravitytask == null) {
                Bukkit.broadcastMessage("Gravity mode starting");
                this.gravitytask = new GravityTask(plugin).runTaskTimer(plugin, 0, 10 * 10);
            } else {
                Bukkit.broadcastMessage("Gravity mode ending");
                this.gravitytask.cancel();
                this.gravitytask = null;
            }
        }
        return false;
    }
}
