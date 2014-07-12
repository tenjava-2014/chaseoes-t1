package com.chaseoes.extraweapons.listeners;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class InteractListener implements Listener {

    @EventHandler
    public void onEntityDamageEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player damager = (Player) event.getDamager();
            ItemStack hand = damager.getItemInHand();

            if (hand != null) {
                if (hand.getType().toString().toLowerCase().trim().endsWith("axe")) {
                    if (hand.hasItemMeta()) {
                        if (hand.getItemMeta().hasDisplayName()) {
                            if (ChatColor.stripColor(hand.getItemMeta().getDisplayName()).equals("Blast 'n Slash")) {
                                Random r = new Random();
                                float chance = r.nextFloat();
                                if (chance <= 0.10f) { // 10% chance of creating an explosion.
                                    event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 3L);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

}
