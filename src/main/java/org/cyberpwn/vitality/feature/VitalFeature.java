package org.cyberpwn.vitality.feature;

import org.cyberpwn.vitality.Vitality;
import org.cyberpwn.vitality.util.ConfigurableObject;
import org.cyberpwn.vitality.util.Protocol;
import org.cyberpwn.vitality.util.ProtocolRange;

public abstract class VitalFeature extends ConfigurableObject implements Feature
{
	private ProtocolRange range;
	
	public VitalFeature(ProtocolRange range)
	{
		super("u");
		
		this.range = range;
		updateCodeName(getClass().getSimpleName().replaceAll("Feature", ""));
		Vitality.instance.getFeatureController().registerFeature(this);
	}
	
	@Override
	public boolean supports(Protocol p)
	{
		return getProtocolRange().contains(p);
	}
	
	@Override
	public ProtocolRange getProtocolRange()
	{
		return range;
	}
}
