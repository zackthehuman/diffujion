package com.zackthehuman.diffujion.seed;

import com.zackthehuman.diffujion.Particle;
import com.zackthehuman.diffujion.Cluster;

/**
 * Seeds a simulation by placing a single seed at the center.
 */
public class CenterSeedStrategy implements SeedStrategy {

	@Override
	public void seed(Cluster cluster) {
		if(null != cluster) {
			int width = cluster.getMaximumWidth();
			int height = cluster.getMaximumHeight();
			
			Particle seed = new Particle(width/2, height/2);
			
			cluster.setSeed(seed);
		} else {
			// TODO: throw exception?
		}
	}

}
