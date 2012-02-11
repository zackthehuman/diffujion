package com.zackthehuman.diffujion;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.zackthehuman.diffujion.seed.CenterSeedStrategy;
import com.zackthehuman.diffujion.spawn.RadialSpawnStrategy;
import com.zackthehuman.diffujion.ui.SimulationRenderingPanel;
import com.zackthehuman.diffujion.walk.RandomWalkStrategy;

public final class Application {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	int width = 256; 
	    		int height = 256;
	    		int particleCount = 3500;
	    		
	    		Simulation simulation = new Simulation(width, height, particleCount);
	    		simulation.setSeeder(new CenterSeedStrategy());
	    		simulation.setSpawner(new RadialSpawnStrategy());
	    		simulation.setWalker(new RandomWalkStrategy());
	    		
	    		simulation.run();

	    		showSimulationResults(simulation);          
	        }
	    });
	}	
	
	private static void showSimulationResults(Simulation simulation) {
		if(null != simulation) {
			Cluster cluster = simulation.getCluster();
			
			if(null != cluster) {
				JFrame frame = new JFrame("Diffujion");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				SimulationRenderingPanel dlaPanel = new SimulationRenderingPanel(simulation);
				dlaPanel.setPreferredSize(new Dimension(cluster.getMaximumWidth(), cluster.getMaximumHeight()));
				
				frame.add(dlaPanel);
				frame.pack();
				frame.setVisible(true);
			}
		}
	}
}
