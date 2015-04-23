package s15cscd580task2;

public class Pathing {
	
	public static Triple orient(Triple strtPnt, Triple endPnt) {
		
		double yaw;
		
		double pitch;
				
		double opposite = endPnt.getY() - strtPnt.getY();
		
		double adjacent = endPnt.getX() - strtPnt.getX();
		
		double vectorZ = endPnt.getZ() - strtPnt.getZ();
		
		double hypotenuse = Math.sqrt((adjacent * adjacent) + (vectorZ * vectorZ));
		
		pitch = Math.toDegrees(Math.atan2(opposite, hypotenuse));
		
		opposite = endPnt.getX() - strtPnt.getX();
		
		adjacent = endPnt.getZ() - strtPnt.getZ();
		
		yaw = Math.toDegrees(Math.atan2(opposite, adjacent));
		
		return new Triple(yaw, pitch, 0.0);
	}
	
	public static double calcLength(Triple pnt1, Triple pnt2) {
		
		Triple vector = pnt1.sub(pnt2);
		
		return Math.sqrt(vector.getX()*vector.getX()+vector.getY()*vector.getY()+vector.getZ()*vector.getZ());
	}
}
