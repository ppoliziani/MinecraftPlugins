package d_apzi.plugins.runner.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.util.Vector;
import sun.jvm.hotspot.opto.Block;

import java.util.List;

public class OnLook implements Listener {

    @EventHandler
    public void onLook(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        //player.sendMessage("You have accessed the move event");
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK | event.getAction() == Action.RIGHT_CLICK_AIR) {
            Block block = (Block) event.getClickedBlock();
            player.sendMessage("That is " + block.getClass().getName());
        }
        /*
        List<Player> playerList = (List<Player>) Bukkit.getOnlinePlayers();
        for (Player p : playerList) {
            player.sendMessage(p.getName());
        }
         */
    }


    /*
    private Player getTarget(Player from) {
        assert from != null;
        // SOME FIXED VALUES (maybe define them globally somewhere):
        // the radius^2:
        double radius2 = 10.0D * 10.0D;
        // the min. dot product (defines the min. angle to the target player)
        // higher value means lower angle means that the player is looking "more directly" at the target):
        // do some experiments, which angle / dotProduct value fits best for your case
        double minDot = 0.98D;

        String fromName = from.getName();
        Location fromLocation = from.getEyeLocation();
        String fromWorldName = fromLocation.getWorld().getName();
        Vector fromDirection = fromLocation.getDirection().normalize();
        Vector fromVectorPos = fromLocation.toVector();

        Player target = null;
        double minDistance2 = Double.MAX_VALUE;
        for (Player somePlayer : Bukkit.getServer().getOnlinePlayers()) {
            if (somePlayer.getName().equals(fromName)) continue;
            Location newTargetLocation = somePlayer.getEyeLocation();
            // check the world:
            if (!newTargetLocation.getWorld().getName().equals(fromWorldName)) continue;
            // check distance:
            double newTargetDistance2 = newTargetLocation.distanceSquared(fromLocation);
            if (newTargetDistance2 > radius2) continue;
            // check angle to target:
            Vector toTarget = newTargetLocation.toVector().subtract(fromVectorPos).normalize();
            // check the dotProduct instead of the angle, because it's faster:
            double dotProduct = toTarget.dot(fromDirection);
            if (dotProduct > minDot && from.hasLineOfSight(somePlayer) && (target == null || newTargetDistance2 < minDistance2)) {
                target = somePlayer;
                minDistance2 = newTargetDistance2;
            }
        }

        // can return null, if no player was found, which meets the conditions:
        return target;
    }
     */


}
