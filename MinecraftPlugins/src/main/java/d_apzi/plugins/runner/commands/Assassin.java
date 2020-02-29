package d_apzi.plugins.runner.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Assassin implements CommandExecutor {

    private List<Player> assassinList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                Player assassin = Bukkit.getPlayerExact(args[0]);
                if (assassin instanceof Player) {
                    if (!assassinList.contains(assassin)) {
                        assassinList.add(assassin);
                        player.getServer().broadcastMessage(ChatColor.GOLD + assassin.getDisplayName() + "is now the assassin");
                        assassin.sendMessage("You have to kill the runner, but every time they see you you will be" +
                                " frozen so make sure to stay out of their view!");

                        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
                        ItemStack beef = new ItemStack(Material.COOKED_BEEF, 16);

                        assassin.getInventory().addItem(sword, beef);
                    } else {
                        assassinList.remove(assassin);
                        player.getServer().broadcastMessage(ChatColor.GOLD + assassin.getDisplayName() + "is no longer the assassin");
                        assassin.sendMessage("You are no longer the assassin");

                        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
                        ItemStack beef = new ItemStack(Material.COOKED_BEEF, 16);

                        assassin.getInventory().remove(sword);
                        assassin.getInventory().remove(beef);
                        assassin.updateInventory();

                    }
                }
            } else {
                player.sendMessage("Need to specify a player name");
            }
        }
        return false;
    }
}
