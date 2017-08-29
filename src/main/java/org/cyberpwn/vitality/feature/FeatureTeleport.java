package org.cyberpwn.vitality.feature;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.cyberpwn.vitality.util.Cuboid;
import org.cyberpwn.vitality.util.Cuboid.CuboidDirection;
import org.cyberpwn.vitality.util.Direction;
import org.cyberpwn.vitality.util.GList;
import org.cyberpwn.vitality.util.VectorMath;

public class FeatureTeleport extends VitalFeature
{
	public boolean forceTeleport(Entity e, Location l)
	{
		return e.teleport(l);
	}
	
	public void lookAtTarget(Entity e, Location l)
	{
		Location lx = e.getLocation().clone();
		lx.setDirection(VectorMath.direction(e.getLocation(), l.clone()));
		e.teleport(lx);
	}
	
	public boolean teleportClose(Entity e, Location l)
	{
		System.out.println(l.getYaw());
		Cuboid c = new Cuboid(l);
		c = c.expand(CuboidDirection.Up, 1);
		c = c.expand(CuboidDirection.Down, 1);
		
		for(Direction i : Direction.news())
		{
			c = c.expand(i.f(), 3);
		}
		
		for(Block i : new GList<Block>(c.iterator()).shuffleCopy())
		{
			if(l.getBlock().equals(i))
			{
				continue;
			}
			
			Location lx = i.getLocation();
			lx.setYaw(l.getYaw());
			lx.setPitch(l.getPitch());
			
			if(isSafe(lx) && isSafe(lx.clone().add(0, 1, 0)) && lx.clone().add(0, -1, 0).getBlock().getType().isSolid())
			{
				System.out.println(l.getYaw());
				return teleport(e, lx);
			}
		}
		
		return false;
	}
	
	public boolean teleport(Entity e, Location l)
	{
		if(isSafe(l))
		{
			if(l.getBlock().getRelative(BlockFace.DOWN).getType().isSolid())
			{
				Location lx = l.getBlock().getLocation().clone().add(0.5, 0.001, 0.5);
				lx.setYaw(l.getYaw());
				lx.setPitch(l.getPitch());
				forceTeleport(e, lx);
				
				return true;
			}
			
			Block c = l.getBlock();
			
			while(c.getY() > 4)
			{
				if(c.getType().isSolid() || c.isLiquid())
				{
					Location lx = l.getBlock().getLocation().clone().add(0.5, 0.001, 0.5);
					lx.setYaw(l.getYaw());
					lx.setPitch(l.getPitch());
					
					if(teleportClose(e, c.getLocation()))
					{
						return true;
					}
				}
				
				c = c.getRelative(BlockFace.DOWN);
			}
		}
		
		return false;
	}
	
	public boolean isSafe(Location... ll)
	{
		for(Location i : ll)
		{
			if(!isSafe(i))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isSafe(Location l)
	{
		Block b = l.getBlock();
		Material m = b.getType();
		
		if(m.isSolid())
		{
			return false;
		}
		
		if(b.isLiquid())
		{
			if(m.toString().contains("LAVA"))
			{
				return false;
			}
		}
		
		return true;
	}
}
