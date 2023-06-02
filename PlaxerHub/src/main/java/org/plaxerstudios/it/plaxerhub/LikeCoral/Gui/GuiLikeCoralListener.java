package org.plaxerstudios.it.plaxerhub.LikeCoral.Gui;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.plaxerstudios.it.plaxerhub.PlaxerHub;

import java.io.File;
import java.util.ArrayList;

public class GuiLikeCoralListener implements Listener {

    private Plugin plugin = PlaxerHub.getPlugin(PlaxerHub.class);
    private File configFile = new File(plugin.getDataFolder(), "PlaxerHubBlock.yml");
    private FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);


    @EventHandler
    public void clickEvent(InventoryClickEvent e){
        String NameOfGui = config.getString("Gui.Name").replace("&", "§");
        Player player = (Player) e.getWhoClicked();


        if(e.getView().getTitle().equalsIgnoreCase(NameOfGui)){
            //set slot
            int slotToReplaceItem = config.getInt("Gui.SlotToReplaceItem");



            String Item1Gui = config.getString("Gui.Item1.Type").toUpperCase();
            Material Item1 = Material.matchMaterial(Item1Gui);
            final ItemStack ItemN1 = new ItemStack(Item1);

            String Item2Gui = config.getString("Gui.Item2.Type").toUpperCase();
            Material Item2 = Material.matchMaterial(Item2Gui);
            final ItemStack ItemN2 = new ItemStack(Item2);

            String Item3Gui = config.getString("Gui.Item3.Type").toUpperCase();
            Material Item3 = Material.matchMaterial(Item3Gui);
            final ItemStack ItemN3 = new ItemStack(Item3);

            String Item4Gui = config.getString("Gui.Item4.Type").toUpperCase();
            Material Item4 = Material.matchMaterial(Item4Gui);
            final ItemStack ItemN4 = new ItemStack(Item4);

            String ItemCloseGui = config.getString("Gui.CloseItem.Type").toUpperCase();
            Material ItemCloseGuiType = Material.matchMaterial(ItemCloseGui);
            final ItemStack close = new ItemStack(ItemCloseGuiType);

            if (e.getCurrentItem().getType() == close.getType()) {
                ItemStack block = new ItemStack(e.getCurrentItem().getType());
                ItemMeta Block_meta = block.getItemMeta();
                Block_meta.setDisplayName("Block");//coso sopra
                ArrayList<String> block_lore = new ArrayList<>();
                block_lore.add("§dDivertitti a piazzare blocchi."); //coso sotto
                Block_meta.setLore(block_lore);
                block.setItemMeta(Block_meta);

                player.getInventory().setItem(slotToReplaceItem, block);
            }
            if (e.getCurrentItem().getType() == ItemN1.getType()) {
                player.closeInventory();

                ItemStack block = new ItemStack(e.getCurrentItem().getType());
                ItemMeta Block_meta = block.getItemMeta();
                Block_meta.setDisplayName("Block");//coso sopra
                ArrayList<String> block_lore = new ArrayList<>();
                block_lore.add("§dDivertitti a piazzare blocchi."); //coso sotto
                Block_meta.setLore(block_lore);
                block.setItemMeta(Block_meta);

                player.getInventory().setItem(slotToReplaceItem, block);
            }
            if (e.getCurrentItem().getType() == ItemN2.getType()) {
                player.closeInventory();
                ItemStack block = new ItemStack(e.getCurrentItem().getType());
                ItemMeta Block_meta = block.getItemMeta();
                Block_meta.setDisplayName("Block");//coso sopra
                ArrayList<String> block_lore = new ArrayList<>();
                block_lore.add("§dDivertitti a piazzare blocchi."); //coso sotto
                Block_meta.setLore(block_lore);
                block.setItemMeta(Block_meta);

                player.getInventory().setItem(slotToReplaceItem, block);
            }
            if (e.getCurrentItem().getType() == ItemN3.getType()) {
                player.closeInventory();
                ItemStack block = new ItemStack(e.getCurrentItem().getType());
                ItemMeta Block_meta = block.getItemMeta();
                Block_meta.setDisplayName("Block");//coso sopra
                ArrayList<String> block_lore = new ArrayList<>();
                block_lore.add("§dDivertitti a piazzare blocchi."); //coso sotto
                Block_meta.setLore(block_lore);
                block.setItemMeta(Block_meta);

                player.getInventory().setItem(slotToReplaceItem, block);
            }
            if (e.getCurrentItem().getType() == ItemN4.getType()) {
                player.closeInventory();

                ItemStack block = new ItemStack(e.getCurrentItem().getType());
                ItemMeta Block_meta = block.getItemMeta();
                Block_meta.setDisplayName("Block");//coso sopra
                ArrayList<String> block_lore = new ArrayList<>();
                block_lore.add("§dDivertitti a piazzare blocchi."); //coso sotto
                Block_meta.setLore(block_lore);
                block.setItemMeta(Block_meta);

                player.getInventory().setItem(slotToReplaceItem, block);
            }




            e.setCancelled(true); //So they cant take the items
        }

    }

}
