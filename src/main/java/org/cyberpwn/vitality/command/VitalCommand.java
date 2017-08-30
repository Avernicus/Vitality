package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.cyberpwn.vitality.CommandController;
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
	protected CommandController cc;
	protected Feature feature;
	
	public VitalCommand(CommandController cc, String command, Feature feature)
	{
		super(command.toLowerCase());
		this.feature = feature;
		this.command = command;
		aliases = new GList<String>(Vitality.instance.getCommand(command).getAliases());
		f = Vitality.instance.getFeatureController();
		this.cc = cc;
		cc.registerCommand(this);
	}
	
	public String tag()
	{
		return TXT.makeTag(C.DARK_GRAY, C.RED, C.GRAY, "Vitality");
	}
	
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
}
