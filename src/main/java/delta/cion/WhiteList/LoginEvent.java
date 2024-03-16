package delta.cion.WhiteList;

import delta.cion.Violet_WhiteList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static delta.cion.Utils.Senders.log;

public class LoginEvent implements Listener {

    @EventHandler
    public void PlayerJoin(PlayerLoginEvent event) {
        if (Violet_WhiteList.getInstance().getConfig().getBoolean("enable_disable")) {
            Player player = event.getPlayer();
            List<String> whitelisted = Violet_WhiteList.getInstance().getConfig().getConfigurationSection("Whitelist").getStringList("players").stream().map(String::toLowerCase).collect(Collectors.toList());
            String pname = player.getName();
            String reason = Objects.requireNonNull(Violet_WhiteList.getInstance().getConfig().getString("no_WL")).replace("{player}", pname);
            String prefix = Violet_WhiteList.getInstance().getConfig().getString("prefix");
            if (!whitelisted.contains(pname.toLowerCase())) {
                event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, ChatColor.translateAlternateColorCodes('&', prefix + reason));
            }
        }
    }
}
