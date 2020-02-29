package d_apzi.plugins.tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerTask extends BukkitRunnable {

    private static Integer Time;
    private static String msg;

    TimerTask(int Time, String msg) {
        TimerTask.Time = Time;
        TimerTask.msg = msg;
    }

    @Override
    public void run() {
        Bukkit.broadcastMessage(ChatColor.GREEN + msg + Time);
        Time--;
        if (Time < 1) {
            this.cancel();
        }
    }
}
