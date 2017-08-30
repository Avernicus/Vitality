package org.cyberpwn.vitality;

import org.cyberpwn.vitality.util.ControllablePlugin;
import org.cyberpwn.vitality.util.Protocol;

public class Vitality extends ControllablePlugin
{
	public static Vitality instance;
	public static Protocol version;
	private FeatureController featureController;
	private CommandController commandController;
	
	@Override
	public void onConstruct()
	{
		instance = this;
		version = Protocol.getProtocolVersion();
		featureController = new FeatureController(this);
		commandController = new CommandController(this);
		i("Bukkit Version: " + getServer().getBukkitVersion());
		i("Supported: " + version.isActualVersion() + " (PLock: " + version.toString() + ")");
	}
	
	@Override
	public void onStart()
	{
		
	}
	
	@Override
	public void onStop()
	{
		
	}
	
	public FeatureController getFeatureController()
	{
		return featureController;
	}
	
	public CommandController getCommandController()
	{
		return commandController;
	}
}
