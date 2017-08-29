package org.cyberpwn.vitality;

import org.cyberpwn.vitality.feature.FeatureTeleportPlayer;
import org.cyberpwn.vitality.util.Controllable;
import org.cyberpwn.vitality.util.Controller;

public class FeatureController extends Controller
{
	private FeatureTeleportPlayer featureTeleportPlayer;
	
	public FeatureController(Controllable parent)
	{
		super(parent);
		
		featureTeleportPlayer = new FeatureTeleportPlayer();
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
}
