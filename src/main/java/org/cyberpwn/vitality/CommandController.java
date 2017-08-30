package org.cyberpwn.vitality;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.cyberpwn.vitality.command.Command;
import org.cyberpwn.vitality.command.CommandTeleport;
import org.cyberpwn.vitality.command.CommandTeleportForce;
import org.cyberpwn.vitality.command.CommandTeleportHere;
import org.cyberpwn.vitality.command.CommandTeleportHereForce;
import org.cyberpwn.vitality.util.C;
import org.cyberpwn.vitality.util.Controllable;
import org.cyberpwn.vitality.util.Controller;
import org.cyberpwn.vitality.util.GList;
import org.cyberpwn.vitality.util.TXT;

public class CommandController extends Controller implements CommandExecutor
{
	private GList<Command> commands;
	private CommandTeleport commandTeleport;
	private CommandTeleportForce commandTeleportForce;
	private CommandTeleportHere commandTeleportHere;
	private CommandTeleportHereForce commandTeleportHereForce;
	
	public CommandController(Controllable parent)
	{
		super(parent);
		
		commands = new GList<Command>();
		FeatureController f = Vitality.instance.getFeatureController();
		commandTeleport = new CommandTeleport(this, f.getFeatureTeleportPlayer());
		commandTeleportForce = new CommandTeleportForce(this, f.getFeatureTeleportPlayer());
		commandTeleportHere = new CommandTeleportHere(this, f.getFeatureTeleportPlayer());
		commandTeleportHereForce = new CommandTeleportHereForce(this, f.getFeatureTeleportPlayer());
	}
	
	@Override
	public void onStart()
	{
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
}
