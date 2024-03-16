package delta.cion.Utils;

import org.bukkit.command.CommandSender;

public interface CmdUtil {
    String Name();
    boolean hasPerm(CommandSender sender);
    void CmdUse(CommandSender sender, String[] args);
}
