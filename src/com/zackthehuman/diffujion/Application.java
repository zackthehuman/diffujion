package com.zackthehuman.diffujion;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.zackthehuman.diffujion.seed.CenterSeedStrategy;
import com.zackthehuman.diffujion.seed.SeedStrategy;
import com.zackthehuman.diffujion.spawn.RandomSpawnStrategy;
import com.zackthehuman.diffujion.spawn.SpawnStrategy;
import com.zackthehuman.diffujion.ui.SimulationRenderingPanel;
import com.zackthehuman.diffujion.walk.RandomWalkStrategy;
import com.zackthehuman.diffujion.walk.WalkStrategy;

public final class Application {
	
	public static void main(String[] args) {
		int width = 256; 
		int height = 256;
		int particleCount = 4096;
		
		Cluster cluster = new Cluster(width, height);
		SeedStrategy seedStrategy = new CenterSeedStrategy();
		SpawnStrategy spawnStrategy = new RandomSpawnStrategy();
		WalkStrategy walkStrategy = new RandomWalkStrategy();
		
		seedStrategy.seed(cluster);
		
		// Walk some particles
		for(int i = 0; i < particleCount; ++i) {
			int steps = 0;
			Particle walker = spawnStrategy.spawn(cluster);
			
			// Simulation starts here
			while(!cluster.canAttach(walker)) {				
				walkStrategy.walk(walker);
				
				//
				// Start value-calculation strategy
				//
				walker.setValue(++steps);
				//
				// End value-calculation strategy
				//
				
				//
				// Start escape-handling strategy
				//
				// If the particle escapes, pick a new staring place and keep going
				if(!cluster.isInBounds(walker)) {
					walker = spawnStrategy.spawn(cluster);
				}
				//
				// End escape-handling strategy
				//
			}
			
			System.out.println("Particle: " + i);
			System.out.println("Steps: " + steps);
			
			boolean attached = cluster.attach(walker);
			
			if(!attached) {
				// TODO: throw exception?
			}
		}
		
		JFrame frame = new JFrame("Diffujion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(cluster.getMaximumWidth(), cluster.getMaximumHeight());
		
		SimulationRenderingPanel dlaPanel = new SimulationRenderingPanel(cluster);
		dlaPanel.setPreferredSize(new Dimension(cluster.getMaximumWidth(), cluster.getMaximumHeight()));
		
		frame.add(dlaPanel);
		frame.pack();
		frame.setVisible(true);

	}	
}
