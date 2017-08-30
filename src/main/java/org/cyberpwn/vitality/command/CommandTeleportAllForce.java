package org.cyberpwn.vitality.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.CommandController;
import org.cyberpwn.vitality.feature.Feature;

public class CommandTeleportAllForce extends VitalCommand
{
	public CommandTeleportAllForce(CommandController cc, Feature f)
	{
		super(cc, "vtpfall", f);
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			if(sender instanceof Player)
			{
				Player px = (Player) sender;
				
				for(Player i : Bukkit.getServer().getOnlinePlayers())
				{
					if(!i.equals(px))
					{
						f.getFeatureTeleportPlayer().teleportToPlayerForce(i, px);
					}
				}
				
				send(sender, "Forcefully Teleporting " + (Bukkit.getServer().getOnlinePlayers().size() - 1) + " player(s) to your location.");
			}
			
			else
			{
				send(sender, "Cannot teleport players to consoles");
			}
			
			return true;
		}
		
		else
		{
			send(sender, "/tpall");
			
			return true;
		}
	}
}
