package delta.cion.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Senders {
    static String Prefix = "&5&lVioWL&8&l >>&r ";
    static String Error = "&4ERROR:\n";
    static String Line = "\n&7&l———————————[&5&lVioWL&7&l]———————————\n";
    public static void send(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix + message));
    }
    public static void info(CommandSender sender, String message) {
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Line + message + Line));
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "\n" + message));
        }
    }
    public static void log(String type, String message) {
        if (type.equalsIgnoreCase("l")) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix + message));
        } else if (type.equalsIgnoreCase("e")) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix + Error +  message));
        } else if (type.equalsIgnoreCase("h")) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + "&4&n" + message + " &8(&eОтладочное&8)"));
        } else {log("e", "&4Ошибка в значении type для log(type, message)");}
    }

    public static void noCMD(CommandSender sender) {
        send(sender, "&4&lНеизвестная команда&6!");
    }
    public static void noPerms(CommandSender sender) {
        send(sender, "&4&lУ вас нет прав&6&l!");
    }
}