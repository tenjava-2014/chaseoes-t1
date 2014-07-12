package com.chaseoes.extraweapons;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.chaseoes.extraweapons.listeners.InteractListener;

public class ExtraWeapons extends JavaPlugin {

    private static ExtraWeapons instance;

    public static ExtraWeapons getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InteractListener(), this);

        CustomCrafting.addBlastNSlash();
    }

    public void onDisable() {
        instance = null;
    }

    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        return true;
    }

}
