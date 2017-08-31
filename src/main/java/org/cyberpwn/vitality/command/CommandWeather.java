package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.feature.Feature;

public class CommandWeather extends VitalCommand
{
	public CommandWeather(Feature f)
	{
		super("vweather", f, "/weather <sun/storm> [ticks]", "Set the world weather duration");
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				
				send(p, (p.getWorld().hasStorm() ? "Storms" : "Sun") + " in " + p.getWorld().getName() + " will continue for " + f.getFeatureWeather().getWeather(p.getWorld()) / 20 / 60 + " minutes.");
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
				
				if(arg[0].equalsIgnoreCase("sun"))
				{
					try
					{
						p.getWorld().setStorm(false);
						f.getFeatureWeather().setWeatherTime(p.getWorld(), Integer.valueOf(12000 * 10));
						send(p, (p.getWorld().hasStorm() ? "Storms" : "Sun") + " in " + p.getWorld().getName() + " will continue for " + f.getFeatureWeather().getWeather(p.getWorld()) / 20 / 60 + " minutes.");
					}
					
					catch(Exception e)
					{
						
					}
				}
				
				if(arg[0].equalsIgnoreCase("rain") || arg[0].equalsIgnoreCase("storm"))
				{
					try
					{
						p.getWorld().setStorm(true);
						f.getFeatureWeather().setWeatherTime(p.getWorld(), Integer.valueOf(12000 * 10));
						send(p, (p.getWorld().hasStorm() ? "Storms" : "Sun") + " in " + p.getWorld().getName() + " will continue for " + f.getFeatureWeather().getWeather(p.getWorld()) / 20 / 60 + " minutes.");
					}
					
					catch(Exception e)
					{
						
					}
				}
			}
			
			else
			{
				send(sender, "Player only");
			}
		}
		
		else if(arg.length == 2)
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				
				if(arg[0].equalsIgnoreCase("sun"))
				{
					try
					{
						f.getFeatureWeather().setWeatherTime(p.getWorld(), Integer.valueOf(arg[1]));
						p.getWorld().setStorm(false);
						send(p, (p.getWorld().hasStorm() ? "Storms" : "Sun") + " in " + p.getWorld().getName() + " will continue for " + f.getFeatureWeather().getWeather(p.getWorld()) / 20 / 60 + " minutes.");
					}
					
					catch(Exception e)
					{
						sendInvalidArgument(sender, arg[1]);
					}
				}
				
				if(arg[0].equalsIgnoreCase("rain") || arg[0].equalsIgnoreCase("storm"))
				{
					try
					{
						f.getFeatureWeather().setWeatherTime(p.getWorld(), Integer.valueOf(arg[1]));
						p.getWorld().setStorm(true);
						send(p, (p.getWorld().hasStorm() ? "Storms" : "Sun") + " in " + p.getWorld().getName() + " will continue for " + f.getFeatureWeather().getWeather(p.getWorld()) / 20 / 60 + " minutes.");
					}
					
					catch(Exception e)
					{
						sendInvalidArgument(sender, arg[1]);
					}
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
