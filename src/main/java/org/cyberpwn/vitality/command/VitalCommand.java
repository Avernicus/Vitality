package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.FeatureController;
import org.cyberpwn.vitality.Vitality;
import org.cyberpwn.vitality.feature.Feature;
import org.cyberpwn.vitality.util.C;
import org.cyberpwn.vitality.util.ConfigurableObject;
import org.cyberpwn.vitality.util.GList;
import org.cyberpwn.vitality.util.TXT;

public abstract class VitalCommand extends ConfigurableObject implements Command
{
	private String command;
	private GList<String> aliases;
	protected FeatureController f;
	protected Feature feature;
	private String usage;
	private String description;
	
	public VitalCommand(String command, Feature feature, String usage, String description)
	{
		super(command.toLowerCase());
		this.usage = usage;
		this.description = description;
		this.feature = feature;
		this.command = command;
		aliases = new GList<String>(Vitality.instance.getCommand(command).getAliases());
		f = Vitality.instance.getFeatureController();
		Vitality.instance.getCommandController().registerCommand(this);
	}
	
	@Override
	public String tag()
	{
		return TXT.makeTag(C.DARK_GRAY, C.RED, C.GRAY, "Vitality");
	}
	
	@Override
	public void send(CommandSender p, String s)
	{
		p.sendMessage(tag() + s);
	}
	
	@Override
	public String getCommandName()
	{
		return command;
	}
	
	@Override
	public GList<String> getCommandAliases()
	{
		return aliases;
	}
	
	@Override
	public Feature getFeatureUsage()
	{
		return feature;
	}
	
	@Override
	public abstract boolean onCommand(String[] arg, CommandSender sender);
	
	@Override
	public String getUsage()
	{
		return usage;
	}
	
	@Override
	public String getDescription()
	{
		return description;
	}
	
	@Override
	public void sendInvalidPlayer(CommandSender s, String player)
	{
		send(s, "Could not find player \"" + player + "\".");
	}
	
	@Override
	public void sendInvalidArgument(CommandSender s, String arg)
	{
		send(s, "Invalid argument \"" + arg + "\".");
	}
	
	@Override
	public void sendPlayerOnly(CommandSender s)
	{
		send(s, "Only players can execute this command.");
	}
	
	@Override
	public void sendConsoleOnly(CommandSender s)
	{
		send(s, "Only consoles can execute this command.");
	}
	
	@Override
	public void sendUsage(CommandSender s)
	{
		send(s, getUsage());
	}
	
	@Override
	public boolean isPlayer(CommandSender s)
	{
		return s instanceof Player;
	}
	
	@Override
	public Player getPlayer(CommandSender s)
	{
		if(isPlayer(s))
		{
			return (Player) s;
		}
		
		return null;
	}
}
