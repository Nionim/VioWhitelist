package delta.cion.WhiteList;

import delta.cion.Violet_WhiteList;
import lombok.Getter;
import java.util.List;
import java.util.Objects;

@Getter
public class WLUtils {

    @Getter
    private static WLUtils instance = new WLUtils();
    private final List<String> whitelisted;


    private WLUtils() {
        instance = this;
        // List
        whitelisted = Objects.requireNonNull(Violet_WhiteList.getInstance().getConfig().getConfigurationSection("Whitelist")).getStringList("players");
    }
}
