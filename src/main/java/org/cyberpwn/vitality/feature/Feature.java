package org.cyberpwn.vitality.feature;

import org.cyberpwn.vitality.util.Protocol;
import org.cyberpwn.vitality.util.ProtocolRange;

public interface Feature
{
	public ProtocolRange getProtocolRange();
	
	public boolean supports(Protocol p);
}
