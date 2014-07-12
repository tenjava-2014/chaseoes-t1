package com.chaseoes.extraweapons;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomCrafting {

    /**
     * Adds the recipe for the Blast N' Slash axe, which has a 10% chance of creating an explosion when used. 
     * This method iterates through all the materials and applies the custom crafting recipe to all axes.
     * 
     * This is how it is crafted in-game: http://i.imgur.com/VdwGWqA.png
     */
    public static ShapedRecipe addBlastNSlash() {
        // Loop through all materials as we want to apply this mechanic to all axes.
        for (Material material : Material.values()) {
            if (material.toString().toLowerCase().trim().endsWith("axe")) {
                ItemStack customAxe = getCustomItem(material, "Blast 'n Slash", "Adds an explosion chance of 10%!");

                // This is what the recipe looks like: http://i.imgur.com/VdwGWqA.png
                ShapedRecipe recipe = new ShapedRecipe(new ItemStack(customAxe));
                recipe.shape(new String[] { " G ", "GAG", " N " });
                recipe.setIngredient('A', material);
                recipe.setIngredient('G', Material.SULPHUR);
                recipe.setIngredient('N', Material.NETHER_STAR);
                ExtraWeapons.getInstance().getServer().addRecipe(recipe);
            }
        }
        return null;
    }

    /**
     * Returns a "custom" item with the specified name and lore. The item will have a green name and the lore (description) will be in gray.
     * 
     * @param material The base material to apply the name and lore to.
     * @param name The custom display name to apply to the returned ItemStack.
     * @param lore The custom lore (description) to apply to the returned ItemStack).
     * @return A custom item with the specified name and lore.
     */
    private static ItemStack getCustomItem(Material material, String name, String lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.GREEN + name);
        im.setLore(new ArrayList<String>(Arrays.asList(ChatColor.GRAY + lore)));
        item.setItemMeta(im);
        return item;
    }

}
