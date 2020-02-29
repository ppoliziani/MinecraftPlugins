package d_apzi.plugins.runner.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class OnDropItem implements Listener {

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        String item = event.getItemDrop().getCustomName();
        player.sendMessage(ChatColor.AQUA + "You dropped " + item);
    }
}
