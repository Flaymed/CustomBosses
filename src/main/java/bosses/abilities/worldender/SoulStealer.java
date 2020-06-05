package bosses.abilities.worldender;

import ability.Ability;
import boss.BossPlayer;
import boss.BossPlayerManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoulStealer extends Ability {
    @Override
    public String getName() {
        return "Soul Stealer";
    }

    @Override
    public void activate() {

        getBoss().addHP((getBoss().getMAXHP() - getBoss().getHP()) * 0.35);
        getBoss().getWorld().playSound(getBoss().getLocation(), Sound.AMBIENCE_THUNDER, 4, 2);

        for (BossPlayer bossPlayer : BossPlayerManager.getBossPlayers()) {
            Player player = bossPlayer.getPlayer();
            player.damage(player.getHealth() * 0.2);
        }
    }

    @Override
    public long getCooldown() {
        return 60;
    }
}
