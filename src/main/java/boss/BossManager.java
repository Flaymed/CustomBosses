package boss;

import bosses.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BossManager {
    private static ArrayList<Boss> bosses = new ArrayList<Boss>();

    public static void spawnBoss(Player player, String name, Location location) {
        switch (name.toLowerCase()) {
            case "broodmother":
                addBoss(new BroodMother(location));
                break;
            case "withergod":
                addBoss(new WitherGod(location));
                break;
            case "zombieking":
                addBoss(new ZombieKing(location));
                break;
            case "worldender":
                addBoss(new WorldEnder(location));
                break;
            default:
                player.sendMessage(String.format("%sCustomBosses> %s Unknown boss type!", ChatColor.RED, ChatColor.GRAY));
        }
    }

    public static void spawnBoss(String bossName, String name, Location location) {
        String boss = "";
        switch (name.toLowerCase()) {
            case "broodmother":
                addBoss(new BroodMother(location));
                boss = "BroodMother";
                break;
            case "withergod":
                addBoss(new WitherGod(location));
                boss = "Wither God";
                break;
            case "zombieking":
                addBoss(new ZombieKing(location));
                boss = "Zombie King";
                break;
        }
        Bukkit.getLogger().info(String.format("[BOSS] World Ender spawned in a %s", boss));
    }

    public static void addBoss(Boss boss) {
        bosses.add(boss);
    }

    public static void removeBoss(Boss boss) {
        bosses.remove(boss);
    }

    public static ArrayList<Boss> getBosses() {
        return bosses;

    }

    public static Boss getBoss(Entity e) {
        for (Boss boss: getBosses()) {
            if (boss.getBossEntity().equals(e))
                return boss;
        }

        return null;
    }
}
