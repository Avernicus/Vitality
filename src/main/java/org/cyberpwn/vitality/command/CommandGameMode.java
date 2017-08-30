package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.Vitality;
import org.cyberpwn.vitality.feature.Feature;
import org.cyberpwn.vitality.util.P;
import org.cyberpwn.vitality.util.VitalGameMode;

public class CommandGameMode extends VitalCommand
{
	public CommandGameMode(Feature f)
	{
		super("vgamemode", f, "/gamemode <type> [other]", "Set gamemodes for players.");
	}
	
	public void u(CommandSender sender)
	{
		sendUsage(sender);
		send(sender, "- 's' or '0' for Survival");
		send(sender, "- 'c' or '1' for Creative");
		send(sender, "- 'a' or '2' for Adventure");
		send(sender, "- 'sp' or '3' for Spectator");
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			u(sender);
		}
		
		else if(arg.length == 1)
		{
			String in = arg[0];
			
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				
				if(in.equals("s") || in.equals("0"))
				{
					VitalGameMode mode = VitalGameMode.SURVIVAL;
					
					if(mode.isSupported())
					{
						f.getFeatureGameMode().switchGamemode(p, mode);
						send(sender, "Set GameMode to " + mode.toString().toLowerCase());
					}
					
					else
					{
						send(sender, mode.toString().toLowerCase() + " mode is not supported on " + Vitality.version.getVersionString() + " (" + mode.getRange().toString() + ")");
					}
				}
				
				else if(in.equals("c") || in.equals("1"))
				{
					VitalGameMode mode = VitalGameMode.CREATIVE;
					
					if(mode.isSupported())
					{
						f.getFeatureGameMode().switchGamemode(p, mode);
						send(sender, "Set GameMode to " + mode.toString().toLowerCase());
					}
					
					else
					{
						send(sender, mode.toString().toLowerCase() + " mode is not supported on " + Vitality.version.getVersionString() + " (" + mode.getRange().toString() + ")");
					}
				}
				
				else if(in.equals("a") || in.equals("2"))
				{
					VitalGameMode mode = VitalGameMode.ADVENTURE;
					
					if(mode.isSupported())
					{
						f.getFeatureGameMode().switchGamemode(p, mode);
						send(sender, "Set GameMode to " + mode.toString().toLowerCase());
					}
					
					else
					{
						send(sender, mode.toString().toLowerCase() + " mode is not supported on " + Vitality.version.getVersionString() + " (" + mode.getRange().toString() + ")");
					}
				}
				
				else if(in.equals("sp") || in.equals("3"))
				{
					VitalGameMode mode = VitalGameMode.SPECTATOR;
					
					if(mode.isSupported())
					{
						f.getFeatureGameMode().switchGamemode(p, mode);
						send(sender, "Set GameMode to " + mode.toString().toLowerCase());
					}
					
					else
					{
						send(sender, mode.toString().toLowerCase() + " mode is not supported on " + Vitality.version.getVersionString() + " (" + mode.getRange().toString() + ")");
					}
				}
				
				else
				{
					u(sender);
				}
			}
			
			else
			{
				send(sender, "Cannot change console's gamemode");
			}
		}
		
		else if(arg.length == 2)
		{
			Player p = P.findPlayer(arg[1]);
			
			if(p != null)
			{
				String in = arg[0];
				
				if(in.equals("s") || in.equals("0"))
				{
					VitalGameMode mode = VitalGameMode.SURVIVAL;
					
					if(mode.isSupported())
					{
						f.getFeatureGameMode().switchGamemode(p, mode);
						send(sender, "Set " + p.getName() + "'s GameMode to " + mode.toString().toLowerCase());
					}
					
					else
					{
						send(sender, mode.toString().toLowerCase() + " mode is not supported on " + Vitality.version.getVersionString() + " (" + mode.getRange().toString() + ")");
					}
				}
				
				else if(in.equals("c") || in.equals("1"))
				{
					VitalGameMode mode = VitalGameMode.CREATIVE;
					
					if(mode.isSupported())
					{
						f.getFeatureGameMode().switchGamemode(p, mode);
						send(sender, "Set " + p.getName() + "'s GameMode to " + mode.toString().toLowerCase());
					}
					
					else
					{
						send(sender, mode.toString().toLowerCase() + " mode is not supported on " + Vitality.version.getVersionString() + " (" + mode.getRange().toString() + ")");
					}
				}
				
				else if(in.equals("a") || in.equals("2"))
				{
					VitalGameMode mode = VitalGameMode.ADVENTURE;
					
					if(mode.isSupported())
					{
						f.getFeatureGameMode().switchGamemode(p, mode);
						send(sender, "Set " + p.getName() + "'s GameMode to " + mode.toString().toLowerCase());
					}
					
					else
					{
						send(sender, mode.toString().toLowerCase() + " mode is not supported on " + Vitality.version.getVersionString() + " (" + mode.getRange().toString() + ")");
					}
				}
				
				else if(in.equals("sp") || in.equals("3"))
				{
					VitalGameMode mode = VitalGameMode.SPECTATOR;
					
					if(mode.isSupported())
					{
						f.getFeatureGameMode().switchGamemode(p, mode);
						send(sender, "Set " + p.getName() + "'s GameMode to " + mode.toString().toLowerCase());
					}
					
					else
					{
						send(sender, mode.toString().toLowerCase() + " mode is not supported on " + Vitality.version.getVersionString() + " (" + mode.getRange().toString() + ")");
					}
				}
				
				else
				{
					u(sender);
				}
			}
			
			else
			{
				send(sender, "Cannot find player \"" + arg[1] + "\"");
			}
		}
		
		else
		{
			u(sender);
		}
		
		return true;
	}
}
