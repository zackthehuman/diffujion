package com.zackthehuman.diffujion.spawn;

import com.zackthehuman.diffujion.Particle;
import com.zackthehuman.diffujion.Simulation;

/**
 * Interface for spawning Particle instances.
 * 
 * @author Zack Mulgrew
 *
 */
public interface SpawnStrategy {
	public Particle spawn(Simulation simulation);
}
