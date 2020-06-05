package bosses.abilities.broodmother;

import ability.Ability;
import org.bukkit.Bukkit;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.List;

public class Spiderling extends Ability {

    public Spiderling() {

    }

    @Override
    public String getName() {
        return "Spiderling";
    }

    @Override
    public void activate() {
        int count = Bukkit.getOnlinePlayers().size();
        List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
        for (int i = 0; i < count; i++) {
            for (int s = 0; s < 5; s++) {
                Entity minion = getBoss().getWorld().spawnEntity(getBoss().getLocation(), EntityType.CAVE_SPIDER);
                ((CaveSpider) minion).setTarget(players.get(i));
            }
        }
    }

    @Override
    public long getCooldown() {
        return 85;
    }
}
