package com.aoki.NoSpecTP;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;

public class NoSpecTP extends JavaPlugin {
	private ProtocolManager protocolManager;
    @Override
    public void onEnable() {
    	protocolManager = ProtocolLibrary.getProtocolManager();
    	protocolManager.addPacketListener(
  			  new PacketAdapter(this, ListenerPriority.HIGH, 
  			          PacketType.Play.Client.SPECTATE) {
  			    @Override
  			    public void onPacketReceiving(PacketEvent event) {
  			        if (event.getPacketType() == 
  			        		PacketType.Play.Client.SPECTATE) {
  			        	if(event.getPlayer().hasPermission("nospec.bypass") == false){
  			        		event.setCancelled(true);
  	  			            event.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.RED+ "SERVER, BITCH" + ChatColor.GRAY+ "]" + ChatColor.DARK_RED + " YEA TOO BAD. I THOUGHT OF THAT FIRST");
  			        	}
  			        }
  			    }
  			});
}
}