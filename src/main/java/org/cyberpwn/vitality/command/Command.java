package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.feature.Feature;
import org.cyberpwn.vitality.util.GList;

public interface Command
{
	public String getCommandName();
	
	public GList<String> getCommandAliases();
	
	public boolean onCommand(String[] arg, CommandSender sender);
	
	public Feature getFeatureUsage();
	
	public String getUsage();
	
	public String getDescription();
	
	public void send(CommandSender p, String s);
	
	public void sendUsage(CommandSender s);
	
	public boolean isPlayer(CommandSender s);
	
	public Player getPlayer(CommandSender s);
	
	public void sendInvalidPlayer(CommandSender s, String player);
	
	public void sendInvalidArgument(CommandSender s, String arg);
	
	public void sendPlayerOnly(CommandSender s);
	
	public void sendConsoleOnly(CommandSender s);
	
	public String tag();
}
