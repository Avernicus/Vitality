package org.cyberpwn.vitality.feature;

import org.bukkit.entity.Player;
import org.cyberpwn.vitality.util.ProtocolRange;
import org.cyberpwn.vitality.util.VitalGameMode;

public class FeatureGameMode extends VitalFeature
{
	public FeatureGameMode(ProtocolRange range)
	{
		super(range);
	}
	
	public void switchGamemode(Player p, VitalGameMode mode)
	{
		p.setGameMode(mode.getGameMode());
	}
}
