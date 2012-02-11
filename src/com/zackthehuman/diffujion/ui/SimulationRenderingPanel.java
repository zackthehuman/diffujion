package com.zackthehuman.diffujion.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.zackthehuman.diffujion.Particle;
import com.zackthehuman.diffujion.Cluster;
import com.zackthehuman.diffujion.Simulation;

import java.awt.image.BufferedImage;

public class SimulationRenderingPanel extends JPanel {
	private static final long serialVersionUID = 69195555469613908L;
	private Simulation simulation;
	private boolean isRenderRequired;
	private BufferedImage modelRendering;
	
	protected Simulation getSimulation() {
		return simulation;
	}
	
	public SimulationRenderingPanel(Simulation simulation) {
		super();
		setSimulation(simulation);
	}
	
	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
		isRenderRequired = true;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(isRenderRequired) {
			Cluster cluster = simulation.getCluster();
			int width = cluster.getMaximumWidth();
			int height = cluster.getMaximumHeight();
			Particle[][] particles = cluster.getParticles();
			
			modelRendering = new BufferedImage(width, height, Image.SCALE_DEFAULT);
			
			Graphics renderingGraphics = modelRendering.getGraphics();
			
			renderingGraphics.setColor(Color.WHITE);
			renderingGraphics.fillRect(0, 0, width, height);
			
			renderingGraphics.setColor(Color.BLACK);
			
			for(int x = 0; x < width; ++x) {
				for(int y = 0; y < height; ++y) {
					if(particles[x][y] != null) {
						renderingGraphics.drawLine(x, y, x, y);
					}
				}
			}
			
			isRenderRequired = false;
		}
		
		//g.drawImage(modelRendering, 0, 0, this);
		g.drawImage(modelRendering, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
