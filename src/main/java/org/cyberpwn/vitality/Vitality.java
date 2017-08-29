package org.cyberpwn.vitality;

import org.cyberpwn.vitality.util.ControllablePlugin;

public class Vitality extends ControllablePlugin
{
	public static Vitality instance;
	private FeatureController featureController;
	private CommandController commandController;
	
	@Override
	public void onConstruct()
	{
		instance = this;
		featureController = new FeatureController(this);
		commandController = new CommandController(this);
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
