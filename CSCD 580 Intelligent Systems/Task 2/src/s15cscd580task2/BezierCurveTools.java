package s15cscd580task2;

import java.util.ArrayList;
import java.util.Random;

public class BezierCurveTools {

	
public static Triple bezier(Triple p1, Triple p2, Triple p3, double t) {
		
		double x = bezierHelper(t, p1.getX(), p2.getX(), p3.getX());
		double y = bezierHelper(t, p1.getY(), p2.getY(), p3.getY());
		double z = bezierHelper(t, p1.getZ(), p2.getZ(), p3.getZ());
		
		return new Triple(x, y, z);
	}
	
	private static double bezierHelper(double t, double p1, double p2, double p3) {
		
		return (p1 * ((1 - t) * (1 - t))) + (2 * (1 - t) * t * p2) + (t * t * p3);
	}
	
	public static Triple bezier(Triple[] points, double t) {
		
		return bezierHelper(points, t, points.length, new BinomialCoefficient(points.length).getArray());
	}
	
	private static Triple bezierHelper(Triple[] points, double t, int size, int[] biCo) {
		
		int i = points.length - size;
		
		if(size == 1)
			return points[points.length - size].mult(Math.pow(t, i));
		
		Triple temp = points[i].mult(Math.pow((1 - t), size - 1) * Math.pow(t, i) * biCo[i]);			
		
		return temp.add(bezierHelper(points, t, size - 1, biCo));
	}
	
	public static Triple bezierCenter(Triple p1, Triple p2) {
		
		return p1.add(p2).div(2.0);		
	}
	
	public static void plotLineRandom(ArrayList<Triple> plot) {
		
		Random randomGen = RandomGen.getInstance().getRandom();
		
		for(int i = 0; i < plot.size(); i++) {
			
			plot.set(i, new Triple(plot.get(i).getX() + (randomGen.nextInt() % 2), over0(plot.get(i).getY() + (randomGen.nextInt() % 4)), plot.get(i).getZ()));
		}
	}
	
	private static double over0(double value) {
		
		if(value < 0)
			return 0;
		
		else
			return value;
	}
}
