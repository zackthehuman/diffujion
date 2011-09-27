package com.zackthehuman.diffujion.spawn;

import com.zackthehuman.diffujion.Particle;
import com.zackthehuman.diffujion.Cluster;

/**
 * Spawns a Particle at a random coordinate within the simulation space.
 * 
 * @author Zack Mulgrew
 *
 */
public class RandomSpawnStrategy implements SpawnStrategy {

	@Override
	public Particle spawn(Cluster simulation) {
		if(null != simulation) {
			int width = simulation.getMaximumWidth();
			int height = simulation.getMaximumHeight();
			
			double spawnX = Math.random() * (width + 1.0);
			double spawnY = Math.random() * (height + 1.0);
			
			return new Particle(spawnX, spawnY);
		}
		
		return null;
	}

}
