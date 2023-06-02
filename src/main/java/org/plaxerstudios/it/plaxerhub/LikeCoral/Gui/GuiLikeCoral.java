package org.plaxerstudios.it.plaxerhub.LikeCoral.Gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.block.data.type.TNT;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.plaxerstudios.it.plaxerhub.PlaxerHub;

import java.io.File;
import java.util.ArrayList;

public class GuiLikeCoral implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender p, Command command, String s, String[] strings) {

        Plugin plugin = PlaxerHub.getPlugin(PlaxerHub.class);

        FileConfiguration config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "PlaxerHubBlock.yml"));

        Player player = (Player) p;

        if(!p.hasPermission("plaxerhub.block")){
            p.sendMessage("§r§lPLAXER§b§lHUB §c You do not have permission to use this command!");
            return true;
        }

        if(!(p instanceof Player)){

            return true;
        }

        if (p.hasPermission("plaxerhub.guilikecoral")) {

            //get block and other
            //
            String ItemCloseGui = config.getString("Gui.CloseItem.Type").toUpperCase();
            String ItemCloseGuiMeta = config.getString("Gui.CloseItem.Meta").replace("&", "§");
            String ItemCloseGuiLore = config.getString("Gui.CloseItem.Lore").replace("&", "§");

            String Item1Gui = config.getString("Gui.Item1.Type").toUpperCase();
            String Item1GuiMeta = config.getString("Gui.Item1.Meta").replace("&", "§");
            String Item1GuiLore = config.getString("Gui.Item1.Lore").replace("&", "§");

            String Item2Gui = config.getString("Gui.Item2.Type").toUpperCase();
            String Item2GuiMeta = config.getString("Gui.Item2.Meta").replace("&", "§");
            String Item2GuiLore = config.getString("Gui.Item2.Lore").replace("&", "§");

            String Item3Gui = config.getString("Gui.Item3.Type").toUpperCase();
            String Item3GuiMeta = config.getString("Gui.Item3.Meta").replace("&", "§");
            String Item3GuiLore = config.getString("Gui.Item3.Lore").replace("&", "§");

            String Item4Gui = config.getString("Gui.Item4.Type").toUpperCase();
            String Item4GuiMeta = config.getString("Gui.Item4.Meta").replace("&", "§");
            String Item4GuiLore = config.getString("Gui.Item4.Lore").replace("&", "§");

            String NameOfGui = config.getString("Gui.Name").replace("&", "§");
            int size = config.getInt("Gui.Size");

            //finish get
            Inventory gui = Bukkit.createInventory(player, size, NameOfGui);

            Material ItemCloseGuiType = Material.matchMaterial(ItemCloseGui);
            ItemStack close = new ItemStack(ItemCloseGuiType);
            Material Item1 = Material.matchMaterial(Item1Gui);
            ItemStack ItemN1 = new ItemStack(Item1);
            Material Item2 = Material.matchMaterial(Item2Gui);
            ItemStack ItemN2 = new ItemStack(Item2);
            Material Item3 = Material.matchMaterial(Item3Gui);
            ItemStack ItemN3 = new ItemStack(Item3);
            Material Item4 = Material.matchMaterial(Item4Gui);
            ItemStack ItemN4 = new ItemStack(Item4);



            //Edit the items
            ItemMeta close_meta = close.getItemMeta();
            close_meta.setDisplayName(ItemCloseGuiMeta);//coso sopra
            ArrayList<String> close_lore = new ArrayList<>();
            close_lore.add(ItemCloseGuiLore); //coso sotto
            close_meta.setLore(close_lore);
            close.setItemMeta(close_meta);

            ItemMeta ItemN1meta = ItemN1.getItemMeta();
            ItemN1meta.setDisplayName(Item1GuiMeta);//coso sopra
            ArrayList<String> ItemN1lore = new ArrayList<>();
            ItemN1lore.add(Item1GuiLore); //coso sotto
            ItemN1meta.setLore(ItemN1lore);
            ItemN1.setItemMeta(ItemN1meta);

            ItemMeta ItemN2meta = ItemN2.getItemMeta();
            ItemN2meta.setDisplayName(Item2GuiMeta);//coso sopra
            ArrayList<String> ItemN2lore = new ArrayList<>();
            ItemN2lore.add(Item2GuiLore); //coso sotto
            ItemN2meta.setLore(ItemN2lore);
            ItemN2.setItemMeta(ItemN2meta);

            ItemMeta ItemN3meta = ItemN3.getItemMeta();
            ItemN3meta.setDisplayName(Item3GuiMeta);
            ArrayList<String> ItemN3lore = new ArrayList<>();
            ItemN3lore.add(Item3GuiLore);
            ItemN3meta.setLore(ItemN3lore);
            ItemN3.setItemMeta(ItemN3meta);

            ItemMeta ItemN4meta = ItemN4.getItemMeta();
            ItemN4meta.setDisplayName(Item4GuiMeta);
            ArrayList<String> ItemN4lore = new ArrayList<>();
            ItemN4lore.add(Item4GuiLore);
            ItemN4meta.setLore(ItemN4lore);
            ItemN4.setItemMeta(ItemN4meta);


            //Put the items in the inventory
            gui.setItem(10, close);
            gui.setItem(13, ItemN1);
            gui.setItem(14, ItemN2);
            gui.setItem(15, ItemN3);
            gui.setItem(16, ItemN4);
            player.openInventory(gui);


        }

        return false;
    }
}
