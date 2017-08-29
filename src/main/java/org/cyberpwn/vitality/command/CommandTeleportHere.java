package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.CommandController;
import org.cyberpwn.vitality.util.P;

public class CommandTeleportHere extends VitalCommand
{
	public CommandTeleportHere(CommandController cc)
	{
		super(cc, "vtphere");
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			send(sender, "/tphere <player>");
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
				
				if(f.getFeatureTeleportPlayer().teleportToPlayerClose(p, s) || f.getFeatureTeleportPlayer().teleportToPlayer(p, s))
				{
					send(sender, "Teleporting " + p.getName() + " to you.");
				}
				
				else
				{
					send(sender, "Could not teleport " + p.getName() + " to you. Try /tpfhere");
				}
				
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
			send(sender, "/tphere <player>");
			
			return true;
		}
	}
}
