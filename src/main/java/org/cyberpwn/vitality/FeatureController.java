package org.cyberpwn.vitality;

import org.cyberpwn.vitality.feature.Feature;
import org.cyberpwn.vitality.feature.FeatureGameMode;
import org.cyberpwn.vitality.feature.FeatureGameModeAdventure;
import org.cyberpwn.vitality.feature.FeatureGameModeCreative;
import org.cyberpwn.vitality.feature.FeatureGameModeSpectator;
import org.cyberpwn.vitality.feature.FeatureGameModeSurvival;
import org.cyberpwn.vitality.feature.FeatureTeleportPlayer;
import org.cyberpwn.vitality.feature.FeatureTime;
import org.cyberpwn.vitality.feature.FeatureVitality;
import org.cyberpwn.vitality.feature.FeatureWeather;
import org.cyberpwn.vitality.util.Controllable;
import org.cyberpwn.vitality.util.Controller;
import org.cyberpwn.vitality.util.GList;
import org.cyberpwn.vitality.util.Protocol;

public class FeatureController extends Controller
{
	private GList<Feature> features;
	private FeatureVitality featureVitality;
	private FeatureTeleportPlayer featureTeleportPlayer;
	private FeatureGameMode featureGameMode;
	private FeatureGameModeSurvival featureGameModeSurvival;
	private FeatureGameModeCreative featureGameModeCreative;
	private FeatureGameModeAdventure featureGameModeAdventure;
	private FeatureGameModeSpectator featureGameModeSpectator;
	private FeatureTime featureTime;
	private FeatureWeather featureWeather;
	
	public FeatureController(Controllable parent)
	{
		super(parent);
		
		features = new GList<Feature>();
	}
	
	@Override
	public void onStart()
	{
		featureVitality = new FeatureVitality(Protocol.EARLIEST.to(Protocol.LATEST));
		featureTeleportPlayer = new FeatureTeleportPlayer(Protocol.EARLIEST.to(Protocol.LATEST));
		featureGameMode = new FeatureGameMode(Protocol.EARLIEST.to(Protocol.LATEST));
		featureGameModeSurvival = new FeatureGameModeSurvival(Protocol.EARLIEST.to(Protocol.LATEST));
		featureGameModeCreative = new FeatureGameModeCreative(Protocol.EARLIEST.to(Protocol.LATEST));
		featureGameModeAdventure = new FeatureGameModeAdventure(Protocol.B1_3_1.to(Protocol.LATEST));
		featureGameModeSpectator = new FeatureGameModeSpectator(Protocol.R1_8.to(Protocol.LATEST));
		featureTime = new FeatureTime(Protocol.EARLIEST.to(Protocol.LATEST));
		featureWeather = new FeatureWeather(Protocol.EARLIEST.to(Protocol.LATEST));
	}
	
	@Override
	public void onStop()
	{
		
	}
	
	public GList<Feature> getFeatures()
	{
		return features;
	}
	
	public void registerFeature(Feature f)
	{
		features.add(f);
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
	
	public FeatureVitality getFeatureVitality()
	{
		return featureVitality;
	}
	
	public FeatureTime getFeatureTime()
	{
		return featureTime;
	}
	
	public FeatureWeather getFeatureWeather()
	{
		return featureWeather;
	}
}
