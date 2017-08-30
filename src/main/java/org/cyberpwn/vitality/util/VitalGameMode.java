package org.cyberpwn.vitality.util;

import org.bukkit.GameMode;
import org.cyberpwn.vitality.Vitality;

public enum VitalGameMode
{
	SURVIVAL(Protocol.EARLIEST.to(Protocol.LATEST), 0),
	CREATIVE(Protocol.EARLIEST.to(Protocol.LATEST), 1),
	ADVENTURE(Protocol.B1_3_1.to(Protocol.LATEST), 2),
	SPECTATOR(Protocol.R1_8.to(Protocol.LATEST), 3);
	
	private ProtocolRange range;
	private int number;
	
	private VitalGameMode(ProtocolRange range, int number)
	{
		this.range = range;
		this.number = number;
	}
	
	public ProtocolRange getRange()
	{
		return range;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public boolean isSupported()
	{
		return getRange().contains(Vitality.version);
	}
	
	public GameMode getGameMode()
	{
		return GameMode.valueOf(toString());
	}
}
