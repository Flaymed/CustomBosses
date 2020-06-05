package bosses.abilities.zombieking;

import ability.Ultimate;
import boss.BossPlayer;
import boss.BossPlayerManager;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import java.util.ArrayList;

public class Hoard extends Ultimate {
    @Override
    public String getName() {
        return "Zombie Hoard";
    }

    @Override
    public void activate() {
        getBoss().setInvulnerable(20);
        ArrayList<BossPlayer> bossPlayers = BossPlayerManager.getBossPlayers();
        for (BossPlayer bossPlayer : bossPlayers) {
            Player player = bossPlayer.getPlayer();
            player.playSound(player.getLocation(), Sound.ENDERDRAGON_HIT, 4, 2);
            for (int i = 1; i < 10; i++) {
                Zombie zombie = (Zombie) getBoss().getWorld().spawnEntity(getBoss().getBossEntity().getLocation(), EntityType.ZOMBIE);
                zombie.setBaby(false);
                zombie.setCanPickupItems(false);
                zombie.setTarget(player);
            }
        }
    }

    @Override
    public long getCooldown() {
        return 120;
    }
}
