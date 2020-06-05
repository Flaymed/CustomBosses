package bosses;

import boss.Boss;
import bosses.abilities.zombieking.GroundSlam;
import bosses.abilities.zombieking.Hoard;
import bosses.abilities.zombieking.UnDeadHealing;
import bosses.abilities.zombieking.UndyingRage;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class ZombieKing extends Boss {
    public ZombieKing(Location spawnLocation) {
        super(spawnLocation, EntityType.GIANT, "Zombie King", 100, new Hoard(), GroundSlam.class, UnDeadHealing.class, UndyingRage.class);
    }
}
