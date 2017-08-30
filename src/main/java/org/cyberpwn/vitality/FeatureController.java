package org.cyberpwn.vitality;

import org.cyberpwn.vitality.feature.FeatureGameMode;
import org.cyberpwn.vitality.feature.FeatureGameModeAdventure;
import org.cyberpwn.vitality.feature.FeatureGameModeCreative;
import org.cyberpwn.vitality.feature.FeatureGameModeSpectator;
import org.cyberpwn.vitality.feature.FeatureGameModeSurvival;
import org.cyberpwn.vitality.feature.FeatureTeleportPlayer;
import org.cyberpwn.vitality.util.Controllable;
import org.cyberpwn.vitality.util.Controller;
import org.cyberpwn.vitality.util.Protocol;

public class FeatureController extends Controller
{
	private FeatureTeleportPlayer featureTeleportPlayer;
	private FeatureGameMode featureGameMode;
	private FeatureGameModeSurvival featureGameModeSurvival;
	private FeatureGameModeCreative featureGameModeCreative;
	private FeatureGameModeAdventure featureGameModeAdventure;
	private FeatureGameModeSpectator featureGameModeSpectator;
	
	public FeatureController(Controllable parent)
	{
		super(parent);
		
		featureTeleportPlayer = new FeatureTeleportPlayer(Protocol.EARLIEST.to(Protocol.LATEST));
		featureGameMode = new FeatureGameMode(Protocol.EARLIEST.to(Protocol.LATEST));
		featureGameModeSurvival = new FeatureGameModeSurvival(Protocol.EARLIEST.to(Protocol.LATEST));
		featureGameModeCreative = new FeatureGameModeCreative(Protocol.EARLIEST.to(Protocol.LATEST));
		featureGameModeAdventure = new FeatureGameModeAdventure(Protocol.B1_3_1.to(Protocol.LATEST));
		featureGameModeSpectator = new FeatureGameModeSpectator(Protocol.R1_8.to(Protocol.LATEST));
	}
	
	@Override
	public void onStart()
	{
		
	}
	
	@Override
	public void onStop()
	{
		
	}
	
	public FeatureTeleportPlayer getFeatureTeleportPlayer()
	{
		return featureTeleportPlayer;
	}
	
	public FeatureGameMode getFeatureGameMode()
	{
		return featureGameMode;
	}
	
	public FeatureGameModeSurvival getFeatureGameModeSurvival()
	{
		return featureGameModeSurvival;
	}
	
	public FeatureGameModeCreative getFeatureGameModeCreative()
	{
		return featureGameModeCreative;
	}
	
	public FeatureGameModeAdventure getFeatureGameModeAdventure()
	{
		return featureGameModeAdventure;
	}
	
	public FeatureGameModeSpectator getFeatureGameModeSpectator()
	{
		return featureGameModeSpectator;
	}
}
