package d_apzi.plugins.runner.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class OnKillMob implements Listener {

    @EventHandler
    public void onKillMob(EntityDeathEvent event) {
        Monster monster = (Monster) event.getEntity();
        Player player = monster.getKiller();
        player.sendMessage(ChatColor.RED + "You didnt have to do that you know");

    }
}
