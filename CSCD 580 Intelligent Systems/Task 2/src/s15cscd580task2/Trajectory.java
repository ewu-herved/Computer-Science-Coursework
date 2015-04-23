package s15cscd580task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import s15cscd580task2.Triple;

public class Trajectory {
	
	private Triple currPnt;
	
	private Triple bound;
	
	private Triple vector;
	
	private double length;
	
	private Random randomGen = RandomGen.getInstance().getRandom();
	
	private boolean isJumping = false;
	
	private double t = 0;
	
	private Triple[] jumpStart = new Triple[3];
	
	public Trajectory(Triple currPnt, double length, Triple bound) {
		
		assert currPnt != null;
		assert bound != null;
		
		if(bound.getX() < 0 || bound.getY() < 0 || bound.getZ() < 0)
			throw new RuntimeException("x, y, and z parameters for bound must be positive");
		
		if(length <= 0)
			throw new RuntimeException("length must be greater than 0");
		
		this.currPnt = currPnt;
		this.length = length;
		this.bound = bound;
		
		newVector();
	}
	
	public double getLength() {
		
		return Math.sqrt(vector.getX()*vector.getX()+vector.getY()*vector.getY()+vector.getZ()*vector.getZ());
	}
	
	public Triple getDest() {
		
		return currPnt.add(vector);
	}

	public Triple getCurr() {
		return currPnt;
	}

	public Triple getVector() {
		return vector;
	}
	
	public Trajectory update() {
		
		Triple temp = currPnt.add(vector);
		boolean newVector = false;
		
		if(isJumping) {
			
			if(t == 0) {
				Triple jumpEnd = currPnt.add(vector.mult(10));
				
				if(jumpEnd.getX() > bound.getX() || jumpEnd.getX() < bound.getX() *-1 || jumpEnd.getZ() > bound.getZ() || jumpEnd.getZ() < bound.getZ() * -1)
					isJumping = false;
				else {
					
					Triple apex = currPnt.add(vector.mult(5)).add(new Triple(0.0, 100.0 , 0.0));
					jumpStart[0] = currPnt;
					jumpStart[1] = apex;
					jumpStart[2] = jumpEnd;
					t += .1;
					
					currPnt = BezierCurveTools.bezier(jumpStart[0], jumpStart[1], jumpStart[2], t);
				}
			}
			else if(t >= .9) {
				isJumping = false;
				t = 0;
				currPnt = jumpStart[2];
			}
			else {
				t += .1;
				currPnt = BezierCurveTools.bezier(jumpStart[0], jumpStart[1], jumpStart[2], t);
			}
		}
		
		if(isJumping == false) {
			
			if(temp.getX() > bound.getX()) {
				
				double divisor = temp.getX() / bound.getX();
				double z = temp.getZ() / divisor;
				temp = new Triple(bound.getX(), 0, z);
				newVector = true;
			}
					
			else if(temp.getX() < (bound.getX() * -1)) {
				
				double divisor = temp.getX() / bound.getX() * -1;
				double z = temp.getZ() / divisor;
				temp = new Triple(bound.getX() * -1, 0, z);
				newVector = true;
			}
					
			if(temp.getZ() > bound.getZ()){
				
				double divisor = temp.getZ() / bound.getZ();
				double x = temp.getX() / divisor;
				temp = new Triple(x, 0, bound.getZ());
				newVector = true;
			}
					
			else if(temp.getZ() < (bound.getZ() * -1)) {
				
				double divisor = temp.getZ() / bound.getZ() * -1;
				double x = temp.getX() / divisor;
				temp = new Triple(x, 0, bound.getZ() * -1);
				newVector = true;
			}
			
			currPnt = temp;
		
			if(newVector) {
				
				newVector();
			}
		}
		return this;
	}
	
	private void newVector() {
		
		double angle = randomGen.nextInt() % 89;
		double angleZ = 90;
		double angleX = 180 - angleZ - Math.abs(angle);
		double z = (length / Math.sin(angleZ)) * Math.sin(angle);
		double x = (length / Math.sin(angleZ)) * Math.sin(angleX);
		
		vector = new Triple(x, 0, z);
	}
	
	public void collisionDetect(Map<String, Trajectory> map, String key) {
		
		Map<String, Trajectory> tempMap = new HashMap<>();		
		tempMap.putAll(map);
		
		tempMap.remove(key);
		
		Trajectory[] array = tempMap.values().toArray(new Trajectory[tempMap.size()]);
		
		for(int i = 0; i < array.length; i++) {
			
			Triple temp = array[i].getCurr();
			
			if(currPnt.getX() < (temp.getX() + 20) && currPnt.getX() > (temp.getX() - 20) && currPnt.getZ() < (temp.getZ() + 20) && currPnt.getZ() > (temp.getZ() - 20)) {
				
				newVector();
			}
		}
	}
	
	public void jump() {
		
		int jumpChance = randomGen.nextInt(10);
		
		if(jumpChance == 4)
			isJumping = true;
	}
}
