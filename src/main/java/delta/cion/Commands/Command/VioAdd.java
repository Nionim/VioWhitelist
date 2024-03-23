package delta.cion.Commands.Command;

import delta.cion.Utils.CmdUtil;
import delta.cion.Utils.Senders;
import delta.cion.Violet_WhiteList;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static delta.cion.WhiteList.WLUtils.*;

public class VioAdd implements CmdUtil {
    @Override
    public String Name() {
        return "add";
    }

    @Override
    public boolean hasPerm(CommandSender sender) {
        return sender.hasPermission("viowl.Add");
    }

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
        if (sender.hasPermission("viowl.Add")) {
            String player = args[1].toLowerCase();
            ConfigurationSection playerslist = config.getConfigurationSection("Whitelist");
            List<String> players = Objects.requireNonNull(playerslist).getStringList("players").stream().map(String::toLowerCase).collect(Collectors.toList());
            if (!players.contains(player)) {
                players.add(player);
                playerslist.set("players", players);
                Violet_WhiteList.getInstance().saveConfig();
                Violet_WhiteList.getInstance().reloadConfig();
                Senders.send(sender, Objects.requireNonNull(MSG.getString("Success-add")).replace("{player}", player));
            } else {Senders.send(sender, Objects.requireNonNull(MSG.getString("Error-add")).replace("{player}", player));}

            if (args[1] == null) {
               Senders.send(sender, config.getString("Type-PName"));
            }
        } else {Senders.noPerms(sender);}
    }
}
