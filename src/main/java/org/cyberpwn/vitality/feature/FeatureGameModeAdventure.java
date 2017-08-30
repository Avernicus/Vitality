package org.cyberpwn.vitality.feature;

import org.bukkit.entity.Player;
import org.cyberpwn.vitality.util.ProtocolRange;
import org.cyberpwn.vitality.util.VitalGameMode;

public class FeatureGameModeAdventure extends FeatureGameMode
{
	public FeatureGameModeAdventure(ProtocolRange range)
	{
		super(range);
	}
	
	public void setAdventure(Player p)
	{
		switchGamemode(p, VitalGameMode.ADVENTURE);
	}
}
