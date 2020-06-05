package bosses.abilities.worldender;

import ability.Ability;
import boss.BossPlayer;
import boss.BossPlayerManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class WorldsWrath extends Ability {
    @Override
    public String getName() {
        return "World's Wrath";
    }

    @Override
    public void activate() {
        ArrayList<BossPlayer> bossPlayers = BossPlayerManager.getBossPlayers();

        for (BossPlayer bossPlayer : bossPlayers) {
            Player player = bossPlayer.getPlayer();
            getBoss().getWorld().strikeLightning(player.getLocation());
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 20, 5));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 20, 5));
            player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 4, 2);
        }
    }

    @Override
    public long getCooldown() {
        return 40;
    }
}
