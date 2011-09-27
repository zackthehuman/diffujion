package com.zackthehuman.diffujion;

public class Cluster {
	public static final boolean ATTACHMENT_FAILED = false;
	public static final boolean ATTACHMENT_SUCCEEDED = true;
	private int maximumWidth;
	private int maximumHeight;
	private Particle[][] cluster;
	
	public Cluster(int maximumWidth, int maximumHeight) {
		setMaximumWidth(maximumWidth);
		setMaximumHeight(maximumHeight);
		setCluster(new Particle[getMaximumWidth()][getMaximumHeight()]);
	}

	public int getMaximumWidth() {
		return maximumWidth;
	}
	
	public void setMaximumWidth(int maximumWidth) {
		this.maximumWidth = maximumWidth;
	}
	
	public int getMaximumHeight() {
		return maximumHeight;
	}
	
	public void setMaximumHeight(int maximumHeight) {
		this.maximumHeight = maximumHeight;
	}
	
	public Particle[][] getCluster() {
		return cluster;
	}
	
	private void setCluster(Particle[][] cluster) {
		this.cluster = cluster;
	}
	
	/**
	 * Attempts to attach a Particle to the cluster. If attachment fails false
	 * is returned. If attachment succeeds true is returned.
	 * 
	 * @param particle the Particle to attach
	 * @return true on successful attachment, false otherwise
	 */
	public boolean attach(Particle particle) {
		if(null != particle) {
			int attachX = (int)particle.getX();
			int attachY = (int)particle.getY();
			
			// TODO: check bounds on attachX and attachY
			if(null == cluster[attachX][attachY]) {
				cluster[attachX][attachY] = particle;
				return ATTACHMENT_SUCCEEDED;
			}
			
			return ATTACHMENT_FAILED;
		}
		return ATTACHMENT_FAILED;
	}
}
