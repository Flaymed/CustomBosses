package listeners;

import boss.Boss;
import boss.BossPlayerManager;
import bosses.BroodMother;
import events.BossDealthEvent;
import events.BossSpawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class BossEventListener extends ListenerRegister {

    private int taskid;

    public BossEventListener(JavaPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void bossSpawn(BossSpawnEvent e) {

        //Run the task 2 seconds after this is called, then wait 15 seconds between each call
        int taskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(getPlugin(), new Runnable() {
            public void run() {
                e.getBoss().activateAbilities();

                if (e.getBoss().getBossEntity() instanceof Monster)
                    ((Monster) e.getBoss().getBossEntity()).setTarget(BossPlayerManager.getRandomPlayer());
            }
        }, 2 * 20, 15 * 20);

        this.taskid = taskid;
        Bukkit.getLogger().info(String.format("[INFO] Task id for boss: %s", this.taskid));
    }

    @EventHandler
    public void bossDeath(BossDealthEvent e) {
        Bukkit.getScheduler().cancelTask(this.taskid);

        Boss boss = e.getBoss();
        if (boss == null)
            return;

        if (boss instanceof BroodMother)
            boss.activateUltimate();
    }
}
