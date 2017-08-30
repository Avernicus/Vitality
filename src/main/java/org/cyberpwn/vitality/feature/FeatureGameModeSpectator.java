package org.cyberpwn.vitality.feature;

import org.bukkit.entity.Player;
import org.cyberpwn.vitality.util.ProtocolRange;
import org.cyberpwn.vitality.util.VitalGameMode;

public class FeatureGameModeSpectator extends FeatureGameMode
{
	public FeatureGameModeSpectator(ProtocolRange range)
	{
		super(range);
	}
	
	public void setSpectator(Player p)
	{
		switchGamemode(p, VitalGameMode.SPECTATOR);
	}
}
