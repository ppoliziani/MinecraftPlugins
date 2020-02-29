package d_apzi.plugins.commands;

import d_apzi.plugins.Main;
import d_apzi.plugins.tasks.SwitchTask;
import d_apzi.plugins.tasks.TimerTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class Switch implements CommandExecutor {

    private BukkitTask switchtask = null;
    private final Main plugin;

    public Switch(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
        int playersCapable = 0;
        int MINUTES = 1;

        if (sender instanceof Player) {

            if (this.switchtask == null) {
                for (Player p : playerList) {
                    if (p.getGameMode() == GameMode.SURVIVAL) {
                        playersCapable++;
                    }
                }
                if (playersCapable > 1) {
                    Bukkit.broadcastMessage(ChatColor.GOLD + "The switching has started");
                    this.switchtask = new SwitchTask(plugin).runTaskTimer(this.plugin,
                            0,  20 * 20);
                } else {
                    sender.sendMessage(ChatColor.DARK_RED + "Not enough players in survival mode");
                }
            } else {
                Bukkit.broadcastMessage(ChatColor.GOLD + "The switching has ended");
                this.switchtask.cancel();
                this.switchtask = null;
            }
        }
        return false;
    }
}
