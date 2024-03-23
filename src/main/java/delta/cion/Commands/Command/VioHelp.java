package delta.cion.Commands.Command;

import delta.cion.Utils.CmdUtil;
import delta.cion.Utils.Senders;
import org.bukkit.command.CommandSender;

import static delta.cion.Utils.Senders.info;

public class VioHelp implements CmdUtil {
    @Override
    public String Name() {
        return "help";
    }

    @Override
    public boolean hasPerm(CommandSender sender) {
        return sender.hasPermission("viowl.Help");
    }

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
        if (sender.hasPermission("viowl.Help")) {
            help(sender);
        } else {Senders.noPerms(sender);}
    }

    public static void help(CommandSender sender) {
        info(sender, "&8>> &5/&fviowl - Main command\n\n" +
                     "&8>> &5/&fviowl status <enable|disable>\n" +
                     "&8>> &5/&fviowl add <player>\n" +
                     "&8>> &5/&fviowl remove <player>\n"+
                     "&8>> &5/&fviowl help\n"+
                     "&8>> &5/&fviowl reload");
    }
}
