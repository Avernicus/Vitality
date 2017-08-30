package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.cyberpwn.vitality.Vitality;
import org.cyberpwn.vitality.feature.Feature;
import org.cyberpwn.vitality.util.GList;

public class CommandVitality extends VitalCommand
{
	public CommandVitality(Feature f)
	{
		super("vitality", f, "/vitality", "Vitality base");
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			GList<Feature> features = new GList<Feature>();
			GList<Feature> supported = new GList<Feature>();
			GList<Command> commands = new GList<Command>();
			GList<Command> scommands = new GList<Command>();
			
			features = f.getFeatures().copy();
			commands = Vitality.instance.getCommandController().getCommands().copy();
			
			for(Feature i : features)
			{
				if(i.getProtocolRange().contains(Vitality.version))
				{
					supported.add(i);
				}
			}
			
			for(Command i : commands)
			{
				if(i.getFeatureUsage().getProtocolRange().contains(Vitality.version))
				{
					scommands.add(i);
				}
			}
			
			send(sender, "Vitality " + Vitality.instance.getDescription().getVersion());
			send(sender, "MCV Prot: " + Vitality.version.getVersionString() + " (protocol " + Vitality.version.getVersion() + ")");
			send(sender, features.size() + " of " + supported.size() + " Features support " + Vitality.version.getVersionString());
			send(sender, commands.size() + " of " + scommands.size() + " Commands support " + Vitality.version.getVersionString());
		}
		
		return true;
	}
}
