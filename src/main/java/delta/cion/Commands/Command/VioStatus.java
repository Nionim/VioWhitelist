package delta.cion.Commands.Command;

import delta.cion.Utils.CmdUtil;
import delta.cion.Utils.Senders;
import delta.cion.Violet_WhiteList;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;

import java.util.Objects;

import static delta.cion.WhiteList.WLUtils.MSG;
import static delta.cion.WhiteList.WLUtils.config;

public class VioStatus implements CmdUtil {
    @Override
    public String Name() {return "status";}

    @Override
    public boolean hasPerm(CommandSender sender) {return sender.hasPermission("viowl.Toggle");}

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
        if (args.length == 2) {
            if (!args[1].isEmpty()) {
                if (args[1].equals("enable") || args[1].equals("disable")) {
                    String status = args[1];
                    ConfigurationSection status1 = config.getConfigurationSection("Whitelist");
                    Objects.requireNonNull(status1).set("enable_disable", status);
                    Violet_WhiteList.getInstance().saveConfig();
                    Violet_WhiteList.getInstance().reloadConfig();
                    Senders.send(sender, MSG.getString("Status-Changed") + status);
                } else {
                    Senders.state(sender);
                }
            } else {
                Senders.state(sender);
            }
        } else {Senders.state(sender);}
    }
}
