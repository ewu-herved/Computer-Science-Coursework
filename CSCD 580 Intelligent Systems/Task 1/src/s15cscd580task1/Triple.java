/**
 * Volume class (x, y, z)
 *
 * @author Dan Herve
 */

package s15cscd580task1;

import java.util.Random;

public class Triple {

   /**
    * Double value for x in inches
    */
    
   private final double x;
   
   /**
    * Double value for y in inches
    */
   
   private final double y;
   
   /**
    * Double value for z in inches
    */
    
   private final double z;
   
   /**
    * @param x  position of the x-coordinate
    * @param y  position of the y-coordinate
    * @param z  position of the z-coordinate
    */
   
   private static Random randomGen = RandomGen.getInstance().randomInt();	

   public Triple(double x, double y, double z) {
	   
	   this.x = x;
	   this.y = y;
	   this.z = z;
   }
   
   public Triple(int bound) {
	   
	   this(randomGen.nextInt() % bound, randomGen.nextInt(bound), randomGen.nextInt() % bound);	      
   }
   
   /**
    * returns value of x-coordinate
    * 
    * @return double
    */

   public double getX() {
	   return x;
   }

   /**
    * returns value of y-coordinate
    * 
    * @return double
    */
   
   public double getY() {
	   return y;
   }

   /**
    * returns value of z-coordinate
    * 
    * @return double
    */
   
   public double getZ() {
	   return z;
   }
   
   public Triple add(Triple that) {
	   
	   assert that != null;
	   
	   return new Triple(getX() + that.getX(), getY() + that.getY(), getZ() + that.getZ());
   }
   
   public Triple sub(Triple that) {
	   
	   assert that != null;
	   
	   return new Triple(getX() - that.getX(), getY() - that.getY(), getZ() - that.getZ());
   }
   
   public Triple mult(Triple that) {
	   
	   assert that != null;
	   
	   return new Triple(getX() * that.getX(), getY() * that.getY(), getZ() * that.getZ());
   }
   
   public Triple mult(double num) {
	   
	   return new Triple(getX() * num, getY() * num, getZ() * num);
   }

	public Triple div(Triple that) {
	   
	   assert that != null;
	   
	   return new Triple(getX() / that.getX(), getY() / that.getY(), getZ() / that.getZ());
	}
	
	public Triple div(double num) {
		   
		   return new Triple(getX() / num, getY() / num, getZ() / num);
	}
   
   @Override
	public String toString() {
		
		return String.format("triple x=\"%.1f\" y=\"%.1f\" z=\"%.1f\"", x, y, z);
	}
}
