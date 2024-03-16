package delta.cion.Commands.Command;

import delta.cion.Utils.CmdUtil;
import delta.cion.Utils.Senders;
import delta.cion.Violet_WhiteList;
import org.bukkit.command.CommandSender;

import static delta.cion.Utils.Senders.send;

public class VioReload implements CmdUtil {

    @Override
    public String Name() { return "reload";}

    @Override
    public boolean hasPerm(CommandSender sender) {return sender.hasPermission("viowl.Reload");}

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
        if (sender.hasPermission("viowl.Reload")) {
            Violet_WhiteList.getInstance().reloadConfig();
            send(sender, "&2Конфигурация перезагружена&6!");
        } else {
            Senders.noPerms(sender);
        }
    }
}
