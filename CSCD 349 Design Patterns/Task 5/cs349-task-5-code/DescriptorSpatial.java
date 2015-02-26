public class DescriptorSpatial extends A_Descriptor {

   private DescriptorPositional position;
   
   private DescriptorDimensional dimensions;

   public DescriptorSpatial(DescriptorPositional position,
                            DescriptorDimensional dimensions) {
                            
      this.position = position;
      
      this.dimensions = dimensions;
   }
   
   public DescriptorPositional getPosition() {
   
      return position;
   }
   
   public DescriptorDimensional getDimensions() {
   
      return dimensions;
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append("<descriptor-spatial>\n");
      position.visit_(visitor);
      dimensions.visit_(visitor);
      visitor.append("</descriptor-spatial>\n");
   }
}