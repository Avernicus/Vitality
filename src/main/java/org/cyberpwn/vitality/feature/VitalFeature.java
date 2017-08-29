package org.cyberpwn.vitality.feature;

import org.cyberpwn.vitality.util.ConfigurableObject;

public abstract class VitalFeature extends ConfigurableObject implements Feature
{
	public VitalFeature()
	{
		super("u");
		
		updateCodeName(getClass().getSimpleName().replaceAll("Feature", ""));
	}
}
