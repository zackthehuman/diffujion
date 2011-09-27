package com.zackthehuman.diffujion;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.zackthehuman.diffujion.seed.CenterSeedStrategy;
import com.zackthehuman.diffujion.seed.SeedStrategy;
import com.zackthehuman.diffujion.spawn.RandomSpawnStrategy;
import com.zackthehuman.diffujion.spawn.SpawnStrategy;
import com.zackthehuman.diffujion.ui.SimulationRenderingPanel;

public final class Application {
	
	public static void main(String[] args) {
		int width = 256; 
		int height = 256;
		int particleCount = 4096;
		
		Simulation simulation = new Simulation(width, height);
		SeedStrategy seedStrategy = new CenterSeedStrategy();
		SpawnStrategy spawnStrategy = new RandomSpawnStrategy();
		
		Particle[][] particles = simulation.getCluster();
		
		seedStrategy.seed(simulation);
		
		// Walk some particles
		for(int i = 0; i < particleCount; ++i) {
			int steps = 0;
			Particle walker = spawnStrategy.spawn(simulation);
			
			// Simulation starts here
			while(!isCollidingWithCluster(simulation, walker)) {
				//
				// Start the walk strategy
				//
				int direction = (int)(Math.random() * 1000) % 4;
				
				switch(direction) {
				case 0:
					// Up
					walker.setY(walker.getY() - 1);
					break;
				case 1:
					// Right
					walker.setX(walker.getX() + 1);
					break;
				case 2:
					// Down
					walker.setY(walker.getY() + 1);
					break;
				case 3:
					// Left
					walker.setX(walker.getX() - 1);
					break;
				default:
					break;
				}
				// 
				// End the walk strategy
				//
				
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
				if(!isInBounds(simulation, walker)) {
					walker = spawnStrategy.spawn(simulation);
				}
				//
				// End escape-handling strategy
				//
			}
			
			particles[(int)walker.getX()][(int)walker.getY()] = walker;
		}
		
		JFrame frame = new JFrame("Diffujion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(simulation.getWidth(), simulation.getHeight());
		
		SimulationRenderingPanel dlaPanel = new SimulationRenderingPanel(simulation);
		dlaPanel.setPreferredSize(new Dimension(simulation.getWidth(), simulation.getHeight()));
		
		frame.add(dlaPanel);
		frame.pack();
		frame.setVisible(true);

	}

	private static boolean isInBounds(Simulation simulation, Particle walker) {
		return walker.getX() >= 0 && walker.getX() < simulation.getWidth() 
				&& walker.getY() >= 0 && walker.getY() < simulation.getHeight();
	}

	private static boolean isCollidingWithCluster(Simulation simulation, Particle walker) {
		int x = (int)walker.getX();
		int y = (int)walker.getY();
		int width = simulation.getWidth();
		int height = simulation.getHeight();
		Particle[][] cluster = simulation.getCluster();
		
		Particle above = cluster[Math.min(Math.max(x, 0), width - 1)][Math.min(Math.max(y - 1, 0), height - 1)];
		Particle right = cluster[Math.min(Math.max(x + 1, 0), width - 1)][Math.min(Math.max(y, 0), height - 1)];
		Particle bottom = cluster[Math.min(Math.max(x, 0), width - 1)][Math.min(Math.max(y + 1, 0), height - 1)];
		Particle left = cluster[Math.min(Math.max(x - 1, 0), width - 1)][Math.min(Math.max(y, 0), height - 1)];
		
		return above != null || right != null || bottom != null || left != null;
	}

}
