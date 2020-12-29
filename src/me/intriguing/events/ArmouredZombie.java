package me.intriguing.events;

import me.intriguing.util.Util.NumUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class ArmouredZombie implements Listener {

    @EventHandler
    public void addArmor(CreatureSpawnEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Zombie) {
            if (NumUtil.chance(50)) {
                entity.getEquipment().setArmorContents(
                        new ItemStack[] {
                                new ItemStack(Material.DIAMOND_BOOTS, 1),
                                new ItemStack(Material.DIAMOND_LEGGINGS, 1),
                                new ItemStack(Material.DIAMOND_CHESTPLATE, 1),
                                new ItemStack(Material.DIAMOND_HELMET, 1)
                        }
                );

                // Probs a bad way of doing it, haven't learned NBT Tags
                entity.setCustomName("Armoured Zombie");
                entity.setCustomNameVisible(false);
            }
        }
    }

    @EventHandler
    public void dropDiamonds(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Zombie) {
            if(entity.getCustomName() == null) return;
            if(entity.getCustomName().equals("Armoured Zombie")) {
                Location location = event.getEntity().getLocation();
                location.getWorld().dropItemNaturally(location, new ItemStack(Material.DIAMOND));
            }
        }
    }



}
