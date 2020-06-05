package bosses.abilities.zombieking;

import ability.Ability;
import org.bukkit.ChatColor;

public class UnDeadHealing extends Ability {
    @Override
    public String getName() {
        return "Undead Healing";
    }

    @Override
    public void activate() {
        if (getBoss().getHP() == getBoss().getMAXHP())
            return;

        double missingHP = getBoss().getMAXHP() - getBoss().getHP();
        getBoss().setHP(getBoss().getHP() + (missingHP * 0.15));
    }

    @Override
    public long getCooldown() {
        return 1;
    }

    @Override
    public String getUsedMessage(String abilityName) {
        return String.format("%sCustomBosses> %s%s%s healed 15 percent of his missing health!",
                ChatColor.RED, ChatColor.GREEN, getBoss().getName(), ChatColor.GRAY);
    }
}
