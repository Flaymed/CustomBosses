import commands.CustomBossCommand;
import commands.FightCommand;
import commands.SpawnBossCommand;
import listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {


        registerListeners();
        registerCommands();

    }

    @Override
    public void onDisable() {

    }

    private void registerListeners() {
        new BossHitListener(this);
        new PlayerHitListener(this);
        new WebListener(this);
        new BossEventListener(this);
        new PlayerDeathListener(this);
        new BossDamageListener(this);
        new ExplosionListener(this);
    }

    private void registerCommands() {
        getCommand("customboss").setExecutor(new CustomBossCommand());
        getCommand("fight").setExecutor(new FightCommand());
        getCommand("spawnboss").setExecutor(new SpawnBossCommand());
    }

}
