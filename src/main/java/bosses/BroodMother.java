package bosses;

import boss.Boss;
import bosses.abilities.broodmother.ExplosiveSpiderling;
import bosses.abilities.broodmother.MarkDash;
import bosses.abilities.broodmother.Spiderling;
import bosses.abilities.broodmother.WebSling;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class BroodMother extends Boss {

    public BroodMother(Location location) {
        super(location, EntityType.SPIDER, "BroodMother", 100, new ExplosiveSpiderling(), WebSling.class, MarkDash.class, Spiderling.class);
    }
}
