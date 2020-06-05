package bosses;

import boss.Boss;
import bosses.abilities.withergod.Nuke;
import bosses.abilities.withergod.RageOfWither;
import bosses.abilities.withergod.WitherServants;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class WitherGod extends Boss {
    public WitherGod(Location spawnLocation) {
        super(spawnLocation, EntityType.WITHER, "Wither God", 100, new RageOfWither(), Nuke.class, WitherServants.class);
    }
}
