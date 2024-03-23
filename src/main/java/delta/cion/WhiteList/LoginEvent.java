package delta.cion.WhiteList;

import delta.cion.Utils.Senders;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static delta.cion.WhiteList.WLUtils.config;

public class LoginEvent implements Listener {

    @EventHandler
    public void PlayerJoin(PlayerLoginEvent event) {

        if (Objects.requireNonNull(config.getString("enable_disable")).equalsIgnoreCase("enable")) {
            try {
                Player player = event.getPlayer();
                String p_name = player.getName().toLowerCase();
                String prefix = config.getString("prefix");
                String reason = Objects.requireNonNull(config.getString("no_WL")).replace("{player}", p_name);
                List<String> whitelisted = config.getConfigurationSection("Whitelist").getStringList("players").stream().map(String::toLowerCase).collect(Collectors.toList());
                if (!whitelisted.isEmpty() && !whitelisted.contains(p_name)) {
                        event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, ChatColor.translateAlternateColorCodes('&', prefix + reason));
                }
            } catch (NullPointerException e) {
                Senders.log("l", "&4Config error:&c\n"+e);
            }
        }
    }
}
