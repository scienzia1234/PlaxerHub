package org.plaxerstudios.it.plaxerhub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.plaxerstudios.it.plaxerhub.Command.SpawnCommand;
import org.plaxerstudios.it.plaxerhub.Command.SpawnSet;
import org.plaxerstudios.it.plaxerhub.LikeCoral.BlockDestroy.OnBlockPlace;
import org.plaxerstudios.it.plaxerhub.LikeCoral.Command.CommandManager;
import org.plaxerstudios.it.plaxerhub.LikeCoral.Database.CommandBlockPlaced;
import org.plaxerstudios.it.plaxerhub.LikeCoral.Database.DatabaseUtils;
import org.plaxerstudios.it.plaxerhub.LikeCoral.Database.PlayerBlockListener;
import org.plaxerstudios.it.plaxerhub.LikeCoral.Gui.GuiLikeCoral;
import org.plaxerstudios.it.plaxerhub.Register.RegisterConfig;
import org.plaxerstudios.it.plaxerhub.Register.RegisterEvent;

public final class PlaxerHub extends JavaPlugin {
    private PlaxerHub instance;
    @Override
    public void onEnable() {



        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage("");
        console.sendMessage("");
        console.sendMessage(ChatColor.GREEN + "    PlaxerHub" + ChatColor.GRAY + " v.5.9.6");
        console.sendMessage(ChatColor.GRAY + "    Running on Bukkit - CraftBukkit");
        console.sendMessage("");
        console.sendMessage("");
        console.sendMessage(ChatColor.AQUA + "Copying information from" + ChatColor.LIGHT_PURPLE + " Config.yml...");
        console.sendMessage(ChatColor.AQUA + "Saving the" + ChatColor.LIGHT_PURPLE + " Config.yml...");
        console.sendMessage(ChatColor.AQUA + "Initializing commands...");
        console.sendMessage(ChatColor.GREEN + "Commands created successfully!");
        console.sendMessage(ChatColor.GREEN + "The plugin has been installed correctly");
        console.sendMessage("");
        console.sendMessage("");
        instance = this;
        Bukkit.getPluginManager().registerEvents(new OnBlockPlace(instance), this);

        //Database


        //register Event
        RegisterEvent.registerEvent();
        //register Config
        RegisterConfig.registerConfig();
        //register Command
        this.registerCommand();
        DatabaseUtils.createDatabase();
        DatabaseUtils.setupDatabase();
        DatabaseUtils.getConnection();
        Bukkit.getPluginManager().registerEvents(new PlayerBlockListener(), this);








    }

    private void registerCommand() {

        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("setspawn").setExecutor(new SpawnSet());
        this.getCommand("crgui").setExecutor(new GuiLikeCoral());
        this.getCommand("block").setExecutor(new CommandManager());



    }

    @Override
    public void onDisable() {
        DatabaseUtils.closeConnection();

    }
}
