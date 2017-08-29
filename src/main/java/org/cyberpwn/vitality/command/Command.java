package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.cyberpwn.vitality.util.GList;

public interface Command
{
	public String getCommandName();
	
	public GList<String> getCommandAliases();
	
	public boolean onCommand(String[] arg, CommandSender sender);
}
