package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.feature.Feature;
import org.cyberpwn.vitality.util.P;
import org.cyberpwn.vitality.util.VitalGameMode;

public class CommandGameModeSpectator extends VitalCommand
{
	public CommandGameModeSpectator(Feature f)
	{
		super("vgmsp", f, "/gmsp [other]", "Set gamemode to spectator");
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				
				f.getFeatureGameModeSpectator().setSpectator(p);
				send(sender, "Set GameMode to " + VitalGameMode.SPECTATOR.toString().toLowerCase());
			}
			
			else
			{
				send(sender, "Cannot change console's gamemode");
			}
		}
		
		else if(arg.length == 1)
		{
			Player p = P.findPlayer(arg[0]);
			
			if(p != null)
			{
				
				f.getFeatureGameModeSpectator().setSpectator(p);
				send(sender, "Set " + p.getName() + "'s GameMode to " + VitalGameMode.SPECTATOR.toString().toLowerCase());
			}
			
			else
			{
				send(sender, "Cannot find player \"" + arg[0] + "\"");
			}
		}
		
		else
		{
			send(sender, "/gmsp [other]");
		}
		
		return true;
	}
}
