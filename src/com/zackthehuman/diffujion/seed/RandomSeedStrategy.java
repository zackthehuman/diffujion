package com.zackthehuman.diffujion.seed;

import java.util.Random;

import com.zackthehuman.diffujion.Cluster;
import com.zackthehuman.diffujion.Particle;

/**
 * Seeds a simulation by placing a seed at a random location within the bounds
 * of the specified cluster.
 */
public class RandomSeedStrategy implements SeedStrategy {

	@Override
	public void seed(Cluster cluster) {
		if(null != cluster) {
			int width = cluster.getMaximumWidth();
			int height = cluster.getMaximumHeight();
			Random random = new Random();
			
			Particle seed = new Particle(random.nextInt(width), random.nextInt(height));
			
			cluster.setSeed(seed);
		} else {
			// TODO: throw exception?
		}
	}

}
