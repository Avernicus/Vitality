package org.cyberpwn.vitality.feature;

import org.bukkit.World;
import org.cyberpwn.vitality.util.DescParseTickFormat;
import org.cyberpwn.vitality.util.ProtocolRange;

public class FeatureTime extends VitalFeature
{
	public FeatureTime(ProtocolRange range)
	{
		super(range);
	}
	
	public String getTime(World w)
	{
		return DescParseTickFormat.format12(w.getTime());
	}
	
	public void setTime(World w, String time) throws Exception
	{
		w.setTime(DescParseTickFormat.parse(time));
	}
}
