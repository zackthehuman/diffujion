package com.zackthehuman.diffujion.spawn;

import com.zackthehuman.diffujion.Particle;
import com.zackthehuman.diffujion.Cluster;

/**
 * Interface for spawning Particle instances.
 * 
 * @author Zack Mulgrew
 *
 */
public interface SpawnStrategy {
	public Particle spawn(Cluster cluster);
}
