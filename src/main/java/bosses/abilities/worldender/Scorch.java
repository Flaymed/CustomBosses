package bosses.abilities.worldender;

import ability.Ability;
import boss.BossPlayer;
import boss.BossPlayerManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Scorch extends Ability {
    @Override
    public String getName() {
        return "Scorch";
    }

    @Override
    public void activate() {
        ArrayList<BossPlayer> bossPlayers = BossPlayerManager.getBossPlayers();
        for (BossPlayer bossPlayer : bossPlayers) {
            Player player = bossPlayer.getPlayer();
            int playerX = player.getLocation().getBlockX();
            int playerY = player.getLocation().getBlockY();
            int playerZ = player.getLocation().getBlockZ();

            player.playSound(player.getLocation(), Sound.GHAST_SCREAM, 4, 2);
            for (int x = playerX - 3; x < playerX + 3; x++) {
                for (int z = playerZ - 3; z < playerZ + 3; z++) {
                    player.getWorld().getBlockAt(new Location(player.getWorld(), x, playerY, z)).setType(Material.FIRE);
                }
            }

        }
    }

    @Override
    public long getCooldown() {
        return 30;
    }
}
