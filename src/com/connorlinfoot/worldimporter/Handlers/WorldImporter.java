package com.connorlinfoot.worldimporter.Handlers;

import com.enkelhosting.filemanager.Main;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

import java.io.*;

public class WorldImporter {

    public static void importWorld(String name, String destination) throws IOException {
        String file = "plugins/WorldImporter/worlds/" + name;
        File srcFolder = new File(file);
        File destFolder = new File(destination);

        if(!srcFolder.exists()){
            System.out.println("World does not exist.");
        } else {
            try {
                Main.copyFolder(srcFolder, destFolder);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Completed World Import");
        Bukkit.createWorld(new WorldCreator("game"));
        Bukkit.getWorlds().add(Bukkit.getWorld(name));
    }



}
