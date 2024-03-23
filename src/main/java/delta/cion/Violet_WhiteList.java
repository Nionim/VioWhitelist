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

        this.saveDefaultConfig();
        Objects.requireNonNull(this.getCommand("viowl")).setExecutor(new MainCommand());
        Objects.requireNonNull(this.getCommand("viowl")).setTabCompleter(new MainCommand());
        this.getServer().getPluginManager().registerEvents(new LoginEvent(), this);

        String startMSG = "&5By&6: &2Carde2"+"\n"+"&5For&6: &2Violett Project"+"\n"+"&5DS&6: &2https://discord.gg/MEBkvJbe4P";
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', startMSG));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&5DEVELOPER&8] &7Carde2&6: &dУдачи&6!"));
    }
}
