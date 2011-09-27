package com.zackthehuman.diffujion.seed;

import com.zackthehuman.diffujion.Particle;
import com.zackthehuman.diffujion.Cluster;

/**
 * Seeds a simulation by placing a single seed at the center.
 */
public class CenterSeedStrategy implements SeedStrategy {

	@Override
	public void seed(Cluster simulation) {
		if(null != simulation) {
			int width = simulation.getMaximumWidth();
			int height = simulation.getMaximumHeight();
			Particle[][] cluster = simulation.getCluster();
			
			if(null != cluster) {
				cluster[width/2][height/2] = new Particle(width/2, height/2);
			} else {
				// TODO: throw exception?
			}
		} else {
			// TODO: throw exception?
		}
	}

}
