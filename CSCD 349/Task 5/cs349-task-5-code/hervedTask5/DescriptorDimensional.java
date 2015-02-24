public class DescriptorDimensional extends A_Descriptor {

   private double height;
   
   private double width;
   
   private double depth;
   
   public DescriptorDimensional(double height, double width, double depth) {
   
      this.height = height;
      this.width = width;
      this.depth = depth;
   }
   
   public double getHeight() {
   
      return height;
   }
   
   public double getWidth() {
   
      return width;
   }
   
   public double getDepth() {
   
      return depth;
   }
   
   public void visit_(Visitor visitor) {
   
      visitor.append(("<dimensions height=" + height + " width=" + width + " depth=" + depth + "/>\n"));
   }
}