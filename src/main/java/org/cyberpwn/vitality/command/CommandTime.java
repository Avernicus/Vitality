package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.feature.Feature;

public class CommandTime extends VitalCommand
{
	public CommandTime(Feature f)
	{
		super("vtime", f, "/time <time>", "Set the world time");
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				send(p, "Time in " + p.getWorld().getName() + " set to " + f.getFeatureTime().getTime(p.getWorld()));
			}
			
			else
			{
				send(sender, "Player only");
			}
		}
		
		else if(arg.length == 1)
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				
				try
				{
					f.getFeatureTime().setTime(p.getWorld(), arg[0]);
					send(p, "Time in " + p.getWorld().getName() + " set to " + f.getFeatureTime().getTime(p.getWorld()));
				}
				
				catch(Exception e)
				{
					sendInvalidArgument(p, arg[0]);
				}
			}
			
			else
			{
				send(sender, "Player only");
			}
		}
		
		else
		{
			sendUsage(sender);
		}
		
		return true;
	}
}
