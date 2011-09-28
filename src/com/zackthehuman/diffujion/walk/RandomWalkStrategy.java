package com.zackthehuman.diffujion.walk;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.zackthehuman.diffujion.Particle;

/**
 * Walks a Particle by choosing one of four directions at random and shifting 
 * one unit in that direction.
 * 
 * @author Zack
 *
 */
public class RandomWalkStrategy implements WalkStrategy {
	protected enum Direction {
		UP,
		RIGHT,
		DOWN,
		LEFT;
		
		private static final List<Direction> VALUES = 
				Collections.unmodifiableList(Arrays.asList(values()));
		private static final int SIZE = VALUES.size();
		private static final Random RANDOM = new Random();
		
		public static Direction randomDirection()  {
			return VALUES.get(RANDOM.nextInt(SIZE));
		}
	}

	@Override
	public void walk(Particle particle) {
		if(null != particle) {
			Direction direction = Direction.randomDirection();
			
			switch(direction) {
			case UP:
				particle.setY(particle.getY() - 1);
				break;
			case RIGHT:
				particle.setX(particle.getX() + 1);
				break;
			case DOWN:
				particle.setY(particle.getY() + 1);
				break;
			case LEFT:
				particle.setX(particle.getX() - 1);
				break;
			default:
				break;
			}
		}
	}
}
