package commands;

import boss.BossManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnBossCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player && sender.hasPermission("boss.spawn")) {
            String bossName = args[0];

            BossManager.spawnBoss((Player) sender, bossName, ((Player) sender).getLocation());
        } else {
            sender.sendMessage(String.format("%sCustomBosses>%s You do not have permission to perform this command!", ChatColor.RED, ChatColor.GRAY));
        }

        return true;
    }
}
