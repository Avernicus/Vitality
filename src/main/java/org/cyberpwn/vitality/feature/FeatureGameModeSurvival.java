package org.cyberpwn.vitality.feature;

import org.bukkit.entity.Player;
import org.cyberpwn.vitality.util.ProtocolRange;
import org.cyberpwn.vitality.util.VitalGameMode;

public class FeatureGameModeSurvival extends FeatureGameMode
{
	public FeatureGameModeSurvival(ProtocolRange range)
	{
		super(range);
	}
	
	public void setSurvival(Player p)
	{
		switchGamemode(p, VitalGameMode.SURVIVAL);
	}
}
