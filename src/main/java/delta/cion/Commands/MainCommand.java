package delta.cion.Commands;

import delta.cion.Commands.Command.*;
import delta.cion.Utils.CmdUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static delta.cion.Utils.Senders.noCMD;

public class MainCommand implements CommandExecutor, TabCompleter {

    private final ArrayList<CmdUtil> subCommands = new ArrayList<>();

    public MainCommand() {
        subCommands.add(new VioHelp());
        subCommands.add(new VioAdd());
        subCommands.add(new VioRemove());
        subCommands.add(new VioReload());
        subCommands.add(new VioStatus());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {
        if (args.length > 0) {
            for (CmdUtil cmdUtil : subCommands) {
                if (args[0].equalsIgnoreCase(cmdUtil.Name())) {
                    cmdUtil.CmdUse(sender, args);
                    return true;
                }
            }
            noCMD(sender);
        } else {noCMD(sender);}
        return true;
    }


    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {
        ArrayList<String> CommandList = new ArrayList<>();
        for (CmdUtil cmdUtil : subCommands) {
            if (args.length == 1) {
                CommandList.add(cmdUtil.Name());
            } else if (args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove")) {
                CommandList.add("<nickname>");
            } else if (args[0].equalsIgnoreCase("toggle")) {
                CommandList.add("<enable/disable>");
            } else {CommandList.clear();}
        }
        return CommandList;
    }

}
