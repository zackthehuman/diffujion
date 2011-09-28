package com.zackthehuman.diffujion;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.zackthehuman.diffujion.seed.CenterSeedStrategy;
import com.zackthehuman.diffujion.spawn.RandomSpawnStrategy;
import com.zackthehuman.diffujion.ui.SimulationRenderingPanel;
import com.zackthehuman.diffujion.walk.RandomWalkStrategy;

public final class Application {
	
	public static void main(String[] args) {
		int width = 256; 
		int height = 256;
		int particleCount = 4096;
		
		Simulation simulation = new Simulation(width, height, particleCount);
		simulation.setSeeder(new CenterSeedStrategy());
		simulation.setSpawner(new RandomSpawnStrategy());
		simulation.setWalker(new RandomWalkStrategy());
		
		simulation.run();
		
		Cluster cluster = simulation.getCluster();
		
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
