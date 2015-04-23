package s15cscd580task2;

import java.util.Random;

public class Line3D {
	
	private final Triple strtPnt;
	
	private final Triple endPnt;
	
	private final double length;
	
	private static Random randomGen = RandomGen.getInstance().getRandom();
	
	public Line3D(Triple strtPnt, Triple endPnt) {
		
		assert strtPnt != null;
		assert endPnt != null;
		
		this.strtPnt = strtPnt;
		this.endPnt = endPnt;
		
		Triple vector = strtPnt.sub(endPnt);
		
		length = Math.sqrt(vector.getX()*vector.getX()+vector.getY()*vector.getY()+vector.getZ()*vector.getZ());
	}

	public Triple getStrtPnt() {
		return strtPnt;
	}

	public Triple getEndPnt() {
		return endPnt;
	}
	
	public double getLength() {
		
		return length;
	}
	
	public Triple[] plotLine(int interval) {
		
		Triple[] plot = new Triple[interval];
		
		for(int i = 0; i < plot.length; i++) {
			
			double dist = length * ((double)i / interval);
			
			Triple vector = strtPnt.sub(endPnt);
			
			Triple normal = new Triple(vector.getX() / length, vector.getY() / length, vector.getZ() / length);
			
			plot[plot.length - 1 - i] = new Triple(normal.getX() * dist + endPnt.getX(), normal.getY() * dist + endPnt.getY(), normal.getZ() * dist + endPnt.getZ());
		}
		
		return plot;
	}
	
	public Triple[] plotLineRandom(int interval) {
		
		Triple[] plot = new Triple[interval];
		
		for(int i = 0; i < plot.length; i++) {
			
			double dist = length * ((double)i / interval);
			
			Triple vector = strtPnt.sub(endPnt);
			
			Triple normal = new Triple(vector.getX() / length, vector.getY() / length, vector.getZ() / length);
			
			plot[plot.length - 1 - i] = new Triple(normal.getX() * dist + endPnt.getX() + (randomGen.nextInt() % 5), over0(normal.getY() * dist + endPnt.getY() + (randomGen.nextInt() % 10)), normal.getZ() * dist + endPnt.getZ());
		}
		
		return plot;
	}
	
	private double over0(double value) {
		
		if(value < 0)
			return 0;
		
		else
			return value;
	}
}

