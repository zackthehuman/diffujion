package com.zackthehuman.diffujion;

public class Cluster {
	public static final boolean ATTACHMENT_FAILED = false;
	public static final boolean ATTACHMENT_SUCCEEDED = true;
	private int maximumWidth;
	private int maximumHeight;
	private Particle[][] particles;
	
	public Cluster(int maximumWidth, int maximumHeight) {
		setMaximumWidth(maximumWidth);
		setMaximumHeight(maximumHeight);
		setParticles(new Particle[getMaximumWidth()][getMaximumHeight()]);
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
	
	public Particle[][] getParticles() {
		return particles;
	}
	
	private void setParticles(Particle[][] cluster) {
		this.particles = cluster;
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
			if(!isInBounds(particle)) {
				return false;
			}
			
			int attachX = (int)particle.getX();
			int attachY = (int)particle.getY();
			
			if(null == particles[attachX][attachY]) {
				particles[attachX][attachY] = particle;
				return ATTACHMENT_SUCCEEDED;
			}
			
			return ATTACHMENT_FAILED;
		}
		return ATTACHMENT_FAILED;
	}
	
	public boolean isInBounds(Particle particle) {
		if(null != particle) {
			return particle.getX() >= 0 && particle.getX() < getMaximumWidth() 
					&& particle.getY() >= 0 && particle.getY() < getMaximumHeight();
		}
		return false;
	}
	
	public boolean canAttach(Particle particle) {
		if(null != particle) {
			
			if(!isInBounds(particle)) {
				return false;
			}
			
			int x = (int)particle.getX();
			int y = (int)particle.getY();
			int width = getMaximumWidth();
			int height = getMaximumHeight();
			
			Particle above = particles[x][Math.max(y - 1, 0)];
			Particle right = particles[Math.min(x + 1, width - 1)][y];
			Particle bottom = particles[x][Math.min(y + 1, height - 1)];
			Particle left = particles[Math.max(x - 1, 0)][y];

			return (above != null || right != null || bottom != null || left != null);
		}
		
		return false;
	}
}
