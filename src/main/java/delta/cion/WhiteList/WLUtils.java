package delta.cion.WhiteList;

import delta.cion.Violet_WhiteList;
import lombok.Getter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.Objects;

@Getter
public class WLUtils {

    @Getter
    public static WLUtils instance = new WLUtils();
    private final List<String> whitelisted;
    public static FileConfiguration config;
    public static ConfigurationSection MSG;

    public WLUtils() {
        instance = this;
        // Conf
        config = Violet_WhiteList.getInstance().getConfig();
        MSG = config.getConfigurationSection("Messages");
        // List
        whitelisted = Objects.requireNonNull(config.getConfigurationSection("Whitelist")).getStringList("players");

    }
}
