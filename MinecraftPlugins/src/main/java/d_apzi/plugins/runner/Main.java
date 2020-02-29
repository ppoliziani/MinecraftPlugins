package d_apzi.plugins.runner;

import d_apzi.plugins.runner.commands.Assassin;
import d_apzi.plugins.runner.commands.Normal;
import d_apzi.plugins.runner.commands.Runner;
import d_apzi.plugins.runner.commands.Tax;
import d_apzi.plugins.runner.events.OnDropItem;
import d_apzi.plugins.runner.events.OnKillMob;
import d_apzi.plugins.runner.events.OnLook;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("The server has started");
        System.out.println("The debugger works");

        //commands
        getCommand("assassin").setExecutor(new Assassin());
        getCommand("runner").setExecutor(new Runner());
        getCommand("tax").setExecutor(new Tax());
        getCommand("normal").setExecutor(new Normal());

        //events
        getServer().getPluginManager().registerEvents( new OnDropItem(), this);
        getServer().getPluginManager().registerEvents(new OnKillMob(), this);
        getServer().getPluginManager().registerEvents(new OnLook(), this);

        //runnables...

    }
    @Override
    public void onDisable() {
        System.out.println("The server has stopped");
    }
}
