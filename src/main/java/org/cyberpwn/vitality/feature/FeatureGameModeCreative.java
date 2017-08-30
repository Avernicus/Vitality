package org.cyberpwn.vitality.feature;

import org.bukkit.entity.Player;
import org.cyberpwn.vitality.util.ProtocolRange;
import org.cyberpwn.vitality.util.VitalGameMode;

public class FeatureGameModeCreative extends FeatureGameMode
{
	public FeatureGameModeCreative(ProtocolRange range)
	{
		super(range);
	}
	
	public void setCreative(Player p)
	{
		switchGamemode(p, VitalGameMode.CREATIVE);
	}
}
