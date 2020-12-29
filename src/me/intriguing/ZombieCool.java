package me.intriguing;

import me.intriguing.events.ArmouredZombie;
import org.bukkit.plugin.java.JavaPlugin;

public class ZombieCool extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ArmouredZombie(), this);
    }
}
