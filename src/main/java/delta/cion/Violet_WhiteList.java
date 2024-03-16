package delta.cion;

import delta.cion.Commands.MainCommand;
import delta.cion.WhiteList.LoginEvent;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Violet_WhiteList extends JavaPlugin {

    @Getter
    private static Violet_WhiteList instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        String startMSG =
                "&5By&6: &2Carde2"+
                "\n"+
                "&5For&6: &2Violett Project"+
                "\n"+
                "&5DS&6: &2https://discord.gg/MEBkvJbe4P";

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', startMSG));

        Objects.requireNonNull(getCommand("viowl")).setExecutor(new MainCommand());
        Objects.requireNonNull(getCommand("viowl")).setTabCompleter(new MainCommand());
        getServer().getPluginManager().registerEvents(new LoginEvent(), this);

        if (getConfig().getBoolean("enable_disable")) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&5Status&6: &2Вайтлист включен&6!"));
        } else {Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&5Status&6: &cВайтлист отключен!&6"));}

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Удачи!"));
    }
}
