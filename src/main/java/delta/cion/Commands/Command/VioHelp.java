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
                "&8>> &5/&fviowl help   &6— &5Помощь по плагину\n" +
                "&8>> &5/&fviowl reload &6— &5Перезагрузка плагина\n" +
                "&8>> &5/&fviowl status &6— &5Включить/выключить вайтлист\n" +
                "&8>> &5/&fviowl add  &6— &5Добавить игрока в вайтлист\n" +
                "&8>> &5/&fviowl remove  &6— &5Убрать игрока из вайтлиста");
    }
}
