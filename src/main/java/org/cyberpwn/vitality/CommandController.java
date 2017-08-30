package org.cyberpwn.vitality;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.cyberpwn.vitality.command.Command;
import org.cyberpwn.vitality.command.CommandGameMode;
import org.cyberpwn.vitality.command.CommandGameModeAdventure;
import org.cyberpwn.vitality.command.CommandGameModeCreative;
import org.cyberpwn.vitality.command.CommandGameModeSpectator;
import org.cyberpwn.vitality.command.CommandGameModeSurvival;
import org.cyberpwn.vitality.command.CommandTeleport;
import org.cyberpwn.vitality.command.CommandTeleportAll;
import org.cyberpwn.vitality.command.CommandTeleportAllForce;
import org.cyberpwn.vitality.command.CommandTeleportForce;
import org.cyberpwn.vitality.command.CommandTeleportHere;
import org.cyberpwn.vitality.command.CommandTeleportHereForce;
import org.cyberpwn.vitality.command.CommandVitality;
import org.cyberpwn.vitality.util.C;
import org.cyberpwn.vitality.util.Controllable;
import org.cyberpwn.vitality.util.Controller;
import org.cyberpwn.vitality.util.GList;
import org.cyberpwn.vitality.util.TXT;

public class CommandController extends Controller implements CommandExecutor
{
	private GList<Command> commands;
	private CommandVitality commandVitality;
	private CommandTeleport commandTeleport;
	private CommandTeleportForce commandTeleportForce;
	private CommandTeleportHere commandTeleportHere;
	private CommandTeleportHereForce commandTeleportHereForce;
	private CommandTeleportAll commandTeleportAll;
	private CommandTeleportAllForce commandTeleportAllForce;
	private CommandGameMode commandGameMode;
	private CommandGameModeSurvival commandGameModeSurvival;
	private CommandGameModeCreative commandGameModeCreative;
	private CommandGameModeAdventure commandGameModeAdventure;
	private CommandGameModeSpectator commandGameModeSpectator;
	
	public CommandController(Controllable parent)
	{
		super(parent);
		
		commands = new GList<Command>();
	}
	
	@Override
	public void onStart()
	{
		FeatureController f = Vitality.instance.getFeatureController();
		commandVitality = new CommandVitality(f.getFeatureVitality());
		commandTeleport = new CommandTeleport(f.getFeatureTeleportPlayer());
		commandTeleportForce = new CommandTeleportForce(f.getFeatureTeleportPlayer());
		commandTeleportHere = new CommandTeleportHere(f.getFeatureTeleportPlayer());
		commandTeleportHereForce = new CommandTeleportHereForce(f.getFeatureTeleportPlayer());
		commandTeleportAll = new CommandTeleportAll(f.getFeatureTeleportPlayer());
		commandTeleportAllForce = new CommandTeleportAllForce(f.getFeatureTeleportPlayer());
		commandGameMode = new CommandGameMode(f.getFeatureGameMode());
		commandGameModeSurvival = new CommandGameModeSurvival(f.getFeatureGameModeSurvival());
		commandGameModeCreative = new CommandGameModeCreative(f.getFeatureGameModeCreative());
		commandGameModeAdventure = new CommandGameModeAdventure(f.getFeatureGameModeAdventure());
		commandGameModeSpectator = new CommandGameModeSpectator(f.getFeatureGameModeSpectator());
		
		for(Command i : commands)
		{
			Vitality.instance.getCommand(i.getCommandName()).setExecutor(this);
		}
	}
	
	@Override
	public void onStop()
	{
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args)
	{
		return runCommand(command.getName(), args, sender);
	}
	
	public boolean crossCheck(Command c, String[] arg, CommandSender s)
	{
		if(c.getFeatureUsage().supports(Vitality.version))
		{
			return c.onCommand(arg, s);
		}
		
		else
		{
			s.sendMessage(TXT.makeTag(C.DARK_GRAY, C.RED, C.GRAY, "Vitality") + "/" + c.getCommandName() + " only supports " + c.getFeatureUsage().getProtocolRange().toString());
			
			return true;
		}
	}
	
	public boolean runCommand(String command, String[] arg, CommandSender s)
	{
		i("Running Command: " + command);
		
		for(Command i : commands)
		{
			if(i.getCommandName().equalsIgnoreCase(command))
			{
				s("Found Command (RAW) " + i.getCommandName());
				return crossCheck(i, arg, s);
			}
		}
		
		for(Command i : commands)
		{
			if(i.getCommandAliases().contains(command.toLowerCase()))
			{
				s("Found Command (ALIAS) " + i.getCommandName());
				return crossCheck(i, arg, s);
			}
		}
		
		return false;
	}
	
	public void registerCommand(Command vitalCommand)
	{
		commands.add(vitalCommand);
	}
	
	public GList<Command> getCommands()
	{
		return commands;
	}
	
	public CommandTeleport getCommandTeleport()
	{
		return commandTeleport;
	}
	
	public CommandTeleportForce getCommandTeleportForce()
	{
		return commandTeleportForce;
	}
	
	public CommandTeleportHere getCommandTeleportHere()
	{
		return commandTeleportHere;
	}
	
	public CommandTeleportHereForce getCommandTeleportHereForce()
	{
		return commandTeleportHereForce;
	}
	
	public CommandTeleportAll getCommandTeleportAll()
	{
		return commandTeleportAll;
	}
	
	public CommandTeleportAllForce getCommandTeleportAllForce()
	{
		return commandTeleportAllForce;
	}
	
	public CommandGameMode getCommandGameMode()
	{
		return commandGameMode;
	}
	
	public CommandGameModeSurvival getCommandGameModeSurvival()
	{
		return commandGameModeSurvival;
	}
	
	public CommandGameModeCreative getCommandGameModeCreative()
	{
		return commandGameModeCreative;
	}
	
	public CommandGameModeAdventure getCommandGameModeAdventure()
	{
		return commandGameModeAdventure;
	}
	
	public CommandGameModeSpectator getCommandGameModeSpectator()
	{
		return commandGameModeSpectator;
	}
	
	public CommandVitality getCommandVitality()
	{
		return commandVitality;
	}
}
