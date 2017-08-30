package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.CommandController;
import org.cyberpwn.vitality.feature.Feature;
import org.cyberpwn.vitality.util.P;

public class CommandTeleportHereForce extends VitalCommand
{
	public CommandTeleportHereForce(CommandController cc, Feature f)
	{
		super(cc, "vtpfhere", f);
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			send(sender, "/tpfhere <player>");
			return true;
		}
		
		else if(arg.length == 1)
		{
			Player p = P.findPlayer(arg[0]);
			
			if(p == null)
			{
				send(sender, "Cannot find player \"" + arg[0] + "\"");
				return true;
			}
			
			if(sender instanceof Player)
			{
				Player s = (Player) sender;
				
				if(s.equals(p))
				{
					send(sender, "Cannot teleport to yourself");
					return true;
				}
				
				f.getFeatureTeleportPlayer().teleportToPlayerForce(p, s);
				send(sender, "Forcefully teleporting " + p.getName() + " to you.");
				
				return true;
			}
			
			else
			{
				send(sender, "Cannot teleport to a player to console.");
				return true;
			}
		}
		
		else
		{
			send(sender, "/tpfhere <player>");
			
			return true;
		}
	}
}
