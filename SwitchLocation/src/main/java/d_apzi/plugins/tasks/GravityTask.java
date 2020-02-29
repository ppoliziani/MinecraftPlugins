package d_apzi.plugins.tasks;

import d_apzi.plugins.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class GravityTask extends BukkitRunnable implements Listener {

    private BukkitTask timertask = null;
    private final Main plugin;

    public GravityTask(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
        for (Player player : playerList) {
            player.setGravity(false);
            this.timertask = new TimerTask(0, null).runTaskTimer(plugin, 0, 5 * 20);
            player.setGravity(true);
        }

    }
}
