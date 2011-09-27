package com.zackthehuman.diffujion.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.zackthehuman.diffujion.Particle;

import java.awt.image.BufferedImage;

public class SimulationRenderingPanel extends JPanel {
	private static final long serialVersionUID = 69195555469613908L;
	private Particle[][] model;
	private boolean isRenderRequired;
	private BufferedImage modelRendering;
	
	public SimulationRenderingPanel(Particle[][] model) {
		super();
		setModel(model);
	}
	
	public void setModel(Particle[][] model) {
		this.model = model;
		isRenderRequired = true;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(isRenderRequired) {
			int width = model.length;
			int height = model[0].length;
			
			modelRendering = new BufferedImage(width, height, Image.SCALE_DEFAULT);
			
			Graphics renderingGraphics = modelRendering.getGraphics();
			
			renderingGraphics.setColor(Color.WHITE);
			renderingGraphics.fillRect(0, 0, width, height);
			renderingGraphics.setColor(Color.BLACK);
			
			for(int x = 0; x < width; ++x) {
				for(int y = 0; y < height; ++y) {
					if(model[x][y] != null) {
						renderingGraphics.drawLine(x, y, x, y);
					}
				}
			}
			
			isRenderRequired = false;
		}
		
		g.drawImage(modelRendering, 0, 0, this);
	}
}
