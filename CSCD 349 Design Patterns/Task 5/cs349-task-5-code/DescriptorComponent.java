public class DescriptorComponent extends A_Descriptor implements I_Identifiable {

   private String id;
   
   private DescriptorSpatial descriptor;

   public DescriptorComponent(String id, DescriptorSpatial descriptor) {
   
      this.id = id;
      
      this.descriptor = descriptor;   
   }

   public String getID_() {
   
      return id;
   }
   
   public void visit_(Visitor visitor) {
   
      visitor.append(("descriptor id=" + id + ">\n"));
      descriptor.visit_(visitor);
      visitor.append("</descriptor>\n");
   }
}