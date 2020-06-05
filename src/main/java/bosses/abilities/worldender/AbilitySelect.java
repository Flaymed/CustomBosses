package bosses.abilities.worldender;

import ability.Ultimate;
import bosses.abilities.broodmother.Spiderling;
import bosses.abilities.broodmother.WebSling;
import bosses.abilities.withergod.Nuke;
import bosses.abilities.withergod.WitherServants;
import bosses.abilities.zombieking.GroundSlam;
import bosses.abilities.zombieking.UnDeadHealing;
import bosses.abilities.zombieking.UndyingRage;
import java.util.Random;

public class AbilitySelect extends Ultimate {

    @Override
    public String getName() {
        return "Ability Selector";
    }

    @Override
    public void activate() {
        Class[] abilities = {Spiderling.class, WebSling.class, Nuke.class, WitherServants.class, GroundSlam.class, UnDeadHealing.class, UndyingRage.class};
        Random r = new Random();
        int low = 0;
        int high = abilities.length - 1;
        int randomInt = r.nextInt(high - low) + low;
        getBoss().addAbility(abilities[randomInt]);
    }

    @Override
    public long getCooldown() {
        return 120;
    }
}
