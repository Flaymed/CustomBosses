package listeners;

import boss.Boss;
import boss.BossManager;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BossDamageListener extends ListenerRegister {
    public BossDamageListener(JavaPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void bossDamaged(EntityDamageEvent e) {
        Boss boss = BossManager.getBoss(e.getEntity());

        if (boss == null)
            return;

        if (boss.isInvulnerable())
            ((LivingEntity) boss.getBossEntity()).setHealth(((LivingEntity) boss.getBossEntity()).getMaxHealth());
        else return;

    }

}
