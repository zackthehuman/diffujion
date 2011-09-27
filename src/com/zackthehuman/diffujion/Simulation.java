package com.zackthehuman.diffujion;

public class Simulation {
	private int width;
	private int height;
	private Particle[][] cluster;
	
	public Simulation(int width, int height) {
		setWidth(width);
		setHeight(height);
		setCluster(new Particle[width][height]);
	}

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Particle[][] getCluster() {
		return cluster;
	}
	
	private void setCluster(Particle[][] cluster) {
		this.cluster = cluster;
	}
}
