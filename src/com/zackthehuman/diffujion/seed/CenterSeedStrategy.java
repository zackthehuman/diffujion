package com.zackthehuman.diffujion.seed;

import com.zackthehuman.diffujion.Particle;
import com.zackthehuman.diffujion.Simulation;

/**
 * Seeds a simulation by placing a single seed at the center.
 */
public class CenterSeedStrategy implements SeedStrategy {

	@Override
	public void seed(Simulation simulation) {
		if(null != simulation) {
			int width = simulation.getWidth();
			int height = simulation.getHeight();
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
