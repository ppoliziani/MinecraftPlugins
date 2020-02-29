package d_apzi.plugins.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage("Use /tp <player name> to view players still playing");
    }
}
