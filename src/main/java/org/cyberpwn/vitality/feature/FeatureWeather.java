package org.cyberpwn.vitality.feature;

import org.bukkit.World;
import org.cyberpwn.vitality.util.ProtocolRange;

public class FeatureWeather extends VitalFeature
{
	public FeatureWeather(ProtocolRange range)
	{
		super(range);
	}
	
	public int getWeather(World w)
	{
		return w.getWeatherDuration();
	}
	
	public void setWeatherTime(World w, int ticks)
	{
		w.setWeatherDuration(ticks);
	}
}
