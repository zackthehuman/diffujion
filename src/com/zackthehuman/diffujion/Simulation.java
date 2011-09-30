package com.zackthehuman.diffujion;

import com.zackthehuman.diffujion.seed.SeedStrategy;
import com.zackthehuman.diffujion.spawn.SpawnStrategy;
import com.zackthehuman.diffujion.walk.WalkStrategy;

public class Simulation {
	private int particleCount;
	
	private SeedStrategy seeder;
	private SpawnStrategy spawner;
	private WalkStrategy walker;
	private Cluster cluster;
	
	public Simulation(int width, int height, int particleCount) {
		this.particleCount = particleCount;
		this.cluster = new Cluster(width, height);
	}

	public int getParticleCount() {
		return particleCount;
	}

	public void setParticleCount(int particleCount) {
		this.particleCount = particleCount;
	}

	public SeedStrategy getSeeder() {
		return seeder;
	}

	public void setSeeder(SeedStrategy seeder) {
		this.seeder = seeder;
	}

	public SpawnStrategy getSpawner() {
		return spawner;
	}

	public void setSpawner(SpawnStrategy spawner) {
		this.spawner = spawner;
	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public WalkStrategy getWalker() {
		return walker;
	}

	public void setWalker(WalkStrategy walker) {
		this.walker = walker;
	}
	
	/**
	 * Runs the simulation for all particles. If the simulation is not in a
	 * state where it can run then an <code>IllegalStateException</code> will be thrown.
	 * Check if the Simulation is ready checking if <code>isReady()</code> returns true
	 * before calling this method.
	 */
	public void run() {
		if(isReady()) {
			seeder.seed(getCluster());
			
			for(int particleIteration = 0; particleIteration < particleCount; ++particleIteration) {
				int steps = 0;
				
				Particle particle = spawner.spawn(getCluster());
				
				while(!cluster.canAttach(particle)) {				
					walker.walk(particle);
					particle.setValue(++steps);

					// If the particle escapes, pick a new starting place and keep going
					if(!cluster.isInBounds(particle)) {
						particle = spawner.spawn(cluster);
					}
				}
				
				cluster.attach(particle);
			}
			
		} else {
			throw new IllegalStateException("The simulation has not been properly initialized.");
		}
	}
	
	/**
	 * Determines if the Simulation is in a state where it can run.
	 * 
	 * @return true if Simulation can run, false otherwise
	 */
	private boolean isReady() {
		return (getParticleCount() > 0) && (null != getSeeder())
				&& (null != getSpawner()) && (null != getWalker()) 
				&& (null != getCluster());
	}
}
