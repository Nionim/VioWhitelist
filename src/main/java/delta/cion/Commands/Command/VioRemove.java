package delta.cion.Commands.Command;

import delta.cion.Utils.CmdUtil;
import delta.cion.Utils.Senders;
import delta.cion.Violet_WhiteList;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VioRemove implements CmdUtil {
    @Override
    public String Name() {
        return "remove";
    }

    @Override
    public boolean hasPerm(CommandSender sender) {
        return sender.hasPermission("viowl.Remove");
    }

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
        if (sender.hasPermission("viowl.Remove")) {
            String player = args[1].toLowerCase();
            ConfigurationSection playerslist = Violet_WhiteList.getInstance().getConfig().getConfigurationSection("Whitelist");
            List<String> players = Objects.requireNonNull(playerslist).getStringList("players").stream().map(String::toLowerCase).collect(Collectors.toList());
            if (players.contains(player)) {
                players.remove(player);
                playerslist.set("players", players);
                Violet_WhiteList.getInstance().saveConfig();
                Violet_WhiteList.getInstance().reloadConfig();
                Senders.send(sender, "&2Игрок &r"+player+"&2 успешно удален из вайтлиста&6!");
            } else {Senders.send(sender, "&4Игрок &r"+player+"&4 не был в вайтлисте&6!");}

            if (args[1] == null) {
                Senders.send(sender, "&4Укажите ник игрока&6!");
            }
        } else {Senders.noPerms(sender);}
    }
}