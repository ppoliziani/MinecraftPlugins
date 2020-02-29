package d_apzi.plugins.tasks;

import d_apzi.plugins.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwitchTask extends BukkitRunnable implements Listener {

    private BukkitTask timertask = null;
    private final Main plugin;

    public SwitchTask(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        player.setGameMode(GameMode.SPECTATOR);
    }

    @Override
    public void run() {

        List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
        Collections.shuffle(playerList);

        if (!this.isCancelled()) {
            this.timertask = new TimerTask(10, "Time until switch: ").runTaskTimer(
                    plugin, 10 * 20, 20);
        }

        Player[] ps = new Player[20];
        Location[] ls = new Location[20];

        int psInd = 0;
        int lsInd = 0;

        for (Player p : playerList) {
            if (p.getGameMode() == GameMode.SURVIVAL) {
                ps[psInd] = p;
                ls[lsInd] = p.getLocation();
                psInd++;
                lsInd++;
            }
        }

        for (int y = 0; y < ls.length - 1; y++) {
            for (int z = ps.length - 1; z > -1; z--) {
                if (!(ps[z] == null)) {
                    ps[z].teleport(ls[y]);
                    ps[z] = null;
                    y++;
                }
            }
            ls[y] = null;
        }
    }
}
