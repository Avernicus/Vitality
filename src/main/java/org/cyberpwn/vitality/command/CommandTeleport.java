package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.feature.Feature;
import org.cyberpwn.vitality.util.P;

public class CommandTeleport extends VitalCommand
{
	public CommandTeleport(Feature f)
	{
		super("vtp", f, "/tp <player> [other]", "Teleport players");
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			send(sender, "/tp <player> [other]");
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
				
				if(f.getFeatureTeleportPlayer().teleportToPlayerClose(s, p) || f.getFeatureTeleportPlayer().teleportToPlayer(s, p))
				{
					send(sender, "Teleporting to " + p.getName());
				}
				
				else
				{
					send(sender, "Could not teleport to " + p.getName() + ". Try /tpf.");
				}
				
				return true;
			}
			
			else
			{
				send(sender, "Cannot teleport to a player as console.");
				return true;
			}
		}
		
		else if(arg.length == 2)
		{
			Player p = P.findPlayer(arg[0]);
			
			if(p == null)
			{
				send(sender, "Cannot find player \"" + arg[0] + "\"");
				return true;
			}
			
			Player b = P.findPlayer(arg[1]);
			
			if(b == null)
			{
				send(sender, "Cannot find player \"" + arg[1] + "\"");
				return true;
			}
			
			if(p.equals(b))
			{
				send(sender, "Cannot teleport " + p.getName() + " to self.");
				return true;
			}
			
			if(f.getFeatureTeleportPlayer().teleportToPlayerClose(p, b) || f.getFeatureTeleportPlayer().teleportToPlayer(p, b))
			{
				send(sender, "Teleporting " + p.getName() + " to " + b.getName());
			}
			
			else
			{
				send(sender, "Could not teleport " + p.getName() + " to " + b.getName() + ". Try /tpf.");
			}
			
			return true;
		}
		
		else
		{
			send(sender, "/tp <player> [other]");
			
			return true;
		}
	}
}
