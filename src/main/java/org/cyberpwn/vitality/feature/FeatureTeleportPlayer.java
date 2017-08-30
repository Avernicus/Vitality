package org.cyberpwn.vitality.feature;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.util.ProtocolRange;

public class FeatureTeleportPlayer extends FeatureTeleport
{
	public FeatureTeleportPlayer(ProtocolRange range)
	{
		super(range);
	}
	
	public boolean teleportToPlayerClose(Player p, Player to)
	{
		Location lx = to.getLocation().clone();
		lx.setYaw(p.getLocation().getYaw());
		lx.setPitch(p.getLocation().getPitch());
		boolean bx = teleportClose(p, lx);
		
		if(bx)
		{
			lookAtTarget(p, to.getLocation());
		}
		
		return bx;
	}
	
	public boolean teleportToPlayer(Player p, Player to)
	{
		Location lx = to.getLocation().clone();
		lx.setYaw(p.getLocation().getYaw());
		lx.setPitch(p.getLocation().getPitch());
		return teleport(p, lx);
	}
	
	public boolean teleportToPlayerForce(Player p, Player to)
	{
		Location lx = to.getLocation().clone();
		lx.setYaw(p.getLocation().getYaw());
		lx.setPitch(p.getLocation().getPitch());
		return forceTeleport(p, lx);
	}
}
