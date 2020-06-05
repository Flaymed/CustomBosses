package listeners;

import boss.Boss;
import boss.BossManager;
import boss.BossPlayer;
import boss.BossPlayerManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class BossHitListener extends ListenerRegister {
    public BossHitListener(JavaPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void bossHitEvent(EntityDamageByEntityEvent e) {
        Boss boss = BossManager.getBoss(e.getEntity());
        if (boss == null)
            return;

        if (e.getEntity() instanceof ArmorStand)
            e.setCancelled(true);

        if (e.getEntity().equals(boss.getBossEntity())) {

            if (boss.isInvulnerable()) {
                e.setCancelled(true);
                return;
            }

            if (e.getDamager() instanceof Arrow) {

                ((LivingEntity) e.getEntity()).setHealth(((LivingEntity) e.getEntity()).getMaxHealth());
                Arrow arrow = (Arrow) e.getDamager();
                Player player = (Player) arrow.getShooter();

                boss.setHP(boss.getHP() - 12);
                boss.addDamage(player, 12);

                if (boss.getHP() <= boss.getMAXHP() * 0.1)
                    boss.activateUltimate();

                if (boss.getHP() <= 0)
                    boss.killBoss(player);

                return;
            }

            if (e.getDamager() instanceof Player) {

                ((LivingEntity) e.getEntity()).setHealth(((LivingEntity) e.getEntity()).getMaxHealth());

                if (((Player) e.getDamager()).getItemInHand().getType().equals(Material.DIAMOND_SWORD)) {
                    boss.setHP(boss.getHP() - 10);
                    boss.addDamage(((Player) e.getDamager()), 10);
                } else {
                    boss.setHP(boss.getHP() - 1);
                    boss.addDamage(((Player) e.getDamager()), 1);
                }
            }

            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                e.setCancelled(true);
                ArrayList<BossPlayer> bossPlayers = BossPlayerManager.getBossPlayers();
                for (BossPlayer bossPlayer : bossPlayers) {
                    Player player = bossPlayer.getPlayer();
                    double playerX = player.getLocation().getX();
                    double playerZ = player.getLocation().getZ();
                    double bossX = boss.getBossEntity().getLocation().getX();
                    double bossZ = boss.getBossEntity().getLocation().getZ();
                    double distance = calculateDistanceBetweenPoints(playerX, playerZ, bossX, bossZ);
                    if (distance <= 30)
                        pound(player.getLocation(), player, 2, 5);
                }

            }

            if (boss.getHP() <= boss.getMAXHP() * 0.1)
                boss.activateUltimate();

            if (boss.getHP() <= 0)
                boss.killBoss((Player) e.getDamager());

        }

    }

    private double calculateDistanceBetweenPoints(double x1, double z1, double x2, double z2) {
        double zAbs = Math.abs(z2 - z1);
        double xAbs = Math.abs(x2 - x1);

        return Math.hypot(zAbs, xAbs);
    }

    private void pound(Location currentLoc, Player player, double multiplier, double damage) {
        player.playSound(currentLoc, Sound.IRONGOLEM_DEATH, 4, 2);
        if(multiplier > 1) multiplier = 1;
        Vector vector = fromAtoB(currentLoc, player.getLocation());
        vector.multiply(multiplier * 1.25D).setY(vector.getY() + 1);
        if(vector.getY() > 1D) vector.setY(1D);
        player.setVelocity(vector);
        player.damage(damage);
    }

    private Vector fromAtoB(Location a, Location b) {
        return fromAtoB(a.toVector(), b.toVector());
    }

    private Vector fromAtoB(Vector a, Vector b) {
        return b.subtract(a);
    }

}
