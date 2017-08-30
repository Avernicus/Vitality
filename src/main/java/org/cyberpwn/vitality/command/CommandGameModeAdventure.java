package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.feature.Feature;
import org.cyberpwn.vitality.util.P;
import org.cyberpwn.vitality.util.VitalGameMode;

public class CommandGameModeAdventure extends VitalCommand
{
	public CommandGameModeAdventure(Feature f)
	{
		super("vgma", f, "/gma [other]", "Set gamemode to adventure");
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				
				f.getFeatureGameModeAdventure().setAdventure(p);
				send(sender, "Set GameMode to " + VitalGameMode.ADVENTURE.toString().toLowerCase());
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
				
				f.getFeatureGameModeAdventure().setAdventure(p);
				send(sender, "Set " + p.getName() + "'s GameMode to " + VitalGameMode.ADVENTURE.toString().toLowerCase());
			}
			
			else
			{
				sendInvalidPlayer(sender, arg[0]);
			}
		}
		
		else
		{
			sendUsage(sender);
		}
		
		return true;
	}
}
