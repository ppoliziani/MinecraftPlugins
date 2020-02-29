package d_apzi.plugins.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Rarn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("Says Sir one more time");
            buildIronCageAround(player, 5, 2, true);
        }
        return false;
    }

    public void buildIronCageAround(Entity ent, int sideLength, int height, boolean wantRoof) {
        Material bars = Material.IRON_BARS;
        Location entLoc = ent.getLocation();

        // Let's make sure our preconditions were met.
        if(sideLength < 3 || sideLength % 2 == 0) {
            throw new IllegalArgumentException("You must enter an odd number greater than 3 for the side length");
        }else if(height == 0) {
            throw new IllegalArgumentException("Height must be greater than 0.");
        }

        int delta = (sideLength / 2);
        Location corner1 = new Location(entLoc.getWorld(), entLoc.getBlockX() + delta, entLoc.getBlockY() + 1, entLoc.getBlockZ() - delta);
        Location corner2 = new Location(entLoc.getWorld(), entLoc.getBlockX() - delta, entLoc.getBlockY() + 1, entLoc.getBlockZ() + delta);
        int minX = Math.min(corner1.getBlockX(), corner2.getBlockX());
        int maxX = Math.max(corner1.getBlockX(), corner2.getBlockX());
        int minZ = Math.min(corner1.getBlockZ(), corner2.getBlockZ());
        int maxZ = Math.max(corner1.getBlockZ(), corner2.getBlockZ());

        for(int x = minX; x <= maxX; x++) {
            for(int y = 0; y < height; y++) {
                for(int z = minZ; z <= maxZ; z++) {
                    if((x == minX || x == maxX) || (z == minZ || z == maxZ)) {
                        Block b = corner1.getWorld().getBlockAt(x, entLoc.getBlockY() + y, z);
                        b.setType(bars);
                    }
                    if(y == height - 1) {
                        Block b = corner1.getWorld().getBlockAt(x, entLoc.getBlockY() + y + 1, z);
                        b.setType(bars);
                    }
                }
            }
        }
    }
}
