package d_apzi.plugins;

import d_apzi.plugins.commands.*;
import d_apzi.plugins.events.OnDeath;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Server has started (port-forwarded)");

        //commands
        getCommand("group").setExecutor(new Group());
        getCommand("switch").setExecutor(new Switch(this));
        getCommand("rarn").setExecutor(new Rarn());
        getCommand("gravity").setExecutor(new Gravity(this));
        getCommand("g2").setExecutor(new G2());

        //events
        getServer().getPluginManager().registerEvents( new OnDeath(), this);

    }

    @Override
    public void onDisable() {
        System.out.println("Server has stopped");
    }
}
