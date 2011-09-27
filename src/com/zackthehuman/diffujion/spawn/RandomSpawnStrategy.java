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
	public Particle spawn(Cluster cluster) {
		if(null != cluster) {
			int width = cluster.getMaximumWidth();
			int height = cluster.getMaximumHeight();
			
			double spawnX = Math.random() * (width + 1.0);
			double spawnY = Math.random() * (height + 1.0);
			
			return new Particle(spawnX, spawnY);
		}
		
		return null;
	}

}
