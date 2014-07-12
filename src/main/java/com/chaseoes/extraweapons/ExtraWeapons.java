package com.chaseoes.extraweapons;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ExtraWeapons extends JavaPlugin {
    
    private static ExtraWeapons instance;
    
    public static ExtraWeapons getInstance() {
        return instance;
    }
	
	public void onEnable() {
	    instance = this;
	}
	
	public void onDisable() {
		instance = null;
	}
	
	public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
		return true;
	}

}
