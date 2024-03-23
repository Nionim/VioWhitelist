package delta.cion.Commands.Command;

import delta.cion.Utils.CmdUtil;
import delta.cion.Utils.Senders;
import delta.cion.Violet_WhiteList;
import delta.cion.WhiteList.WLUtils;
import org.bukkit.command.CommandSender;

import static delta.cion.Utils.Senders.send;
import static delta.cion.WhiteList.WLUtils.MSG;

public class VioReload implements CmdUtil {

    @Override
    public String Name() { return "reload";}

    @Override
    public boolean hasPerm(CommandSender sender) {return sender.hasPermission("viowl.Reload");}

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
        if (sender.hasPermission("viowl.Reload")) {
            Violet_WhiteList.getInstance().reloadConfig();
            send(sender, MSG.getString("Reloaded"));
            WLUtils.instance = null;
            WLUtils.instance = new WLUtils();
        } else {
            Senders.noPerms(sender);
        }
    }
}
