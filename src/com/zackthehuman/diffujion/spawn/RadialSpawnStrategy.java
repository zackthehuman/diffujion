package com.zackthehuman.diffujion.spawn;

import java.util.Random;

import com.zackthehuman.diffujion.Cluster;
import com.zackthehuman.diffujion.Particle;

/**
 * Spawns particles at locations based on the Cluster's radius.
 * 
 * @author Zack Mulgrew
 *
 */
public class RadialSpawnStrategy implements SpawnStrategy {
	private static final double DEFAULT_RADIUS_SCALE = 1.1;
	private double radiusSpawnFactor = DEFAULT_RADIUS_SCALE;
	private Random random;
	
	public RadialSpawnStrategy() {
		random = new Random();
	}

	@Override
	public Particle spawn(Cluster cluster) {
		if(null != cluster) {
			double clusterRadius = cluster.getRadius();
			double spawningRadius = clusterRadius * radiusSpawnFactor;
			
			int spawningDiameter = (int)(spawningRadius * 2.0);
			
			if(spawningDiameter >= cluster.getMaximumHeight()) {
				//throw new Exception("Spawning radius exceeded maxiumum height.");
				return null;
			}
			
			if(spawningDiameter >= cluster.getMaximumWidth()) {
				//throw new Exception("Spawning radius exceeded maxiumum width.");
				return null;
			}
			
			double angle = random.nextDouble() * (Math.PI * 2.0);
			Particle seed = cluster.getSeed();
			
			double spawnX = seed.getX() + (spawningRadius * Math.cos(angle));
			double spawnY = seed.getY() + (spawningRadius * Math.sin(angle));
			
			return new Particle(spawnX, spawnY);
		}
		
		return null;
	}

}
