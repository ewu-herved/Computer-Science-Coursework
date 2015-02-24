public class DescriptorPositional extends A_Descriptor {

   private double x;
   
   private double y;
   
   private double z;
   
   public DescriptorPositional(double x, double y, double z) {
   
      this.x = x;
      this.y = y;
      this.z = z;
   }
   
   public double getX() {
   
      return x;
   }
   
   public double getY() {
   
      return y;
   }
   
   public double getZ() {
   
      return z;
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append(("<position x=" + x + " y=" + y + " z=" + z + "/>\n"));
   }
}