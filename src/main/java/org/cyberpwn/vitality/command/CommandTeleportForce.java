package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.CommandController;
import org.cyberpwn.vitality.util.P;

public class CommandTeleportForce extends VitalCommand
{
	public CommandTeleportForce(CommandController cc)
	{
		super(cc, "vtpf");
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			send(sender, "/tpf <player> [other]");
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
				
				f.getFeatureTeleportPlayer().teleportToPlayerForce(s, p);
				send(sender, "Forcefully teleporting to " + p.getName());
				
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
			
			f.getFeatureTeleportPlayer().teleportToPlayerForce(p, b);
			send(sender, "Forcefully teleporting " + p.getName() + " to " + b.getName());
			
			return true;
		}
		
		else
		{
			send(sender, "/tpf <player> [other]");
			
			return true;
		}
	}
}
