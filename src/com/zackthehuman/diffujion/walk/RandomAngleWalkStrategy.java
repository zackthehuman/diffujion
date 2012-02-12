package com.zackthehuman.diffujion.walk;

import com.zackthehuman.diffujion.Particle;

/**
 * Walks a Particle by choosing a random angle and moving in that angle's
 * direction.
 * 
 * @author Zack
 *
 */
public class RandomAngleWalkStrategy implements WalkStrategy {
	
	private static final double TWO_PI = Math.PI * 2;

	@Override
	public void walk(Particle particle) {
		double theta = Math.random() * TWO_PI;
		double stepSize = 1.0;
		
		particle.setX(particle.getX() + (stepSize * Math.cos(theta)));
		particle.setY(particle.getY() + (stepSize * Math.sin(theta)));
	}

}
