package bosses.abilities.worldender;

import ability.Ultimate;

public class WorldEnder extends Ultimate {
    @Override
    public String getName() {
        return "World Ender";
    }

    @Override
    public void activate() {
        getBoss().rampage(20);
    }

    @Override
    public long getCooldown() {
        return 120;
    }
}
