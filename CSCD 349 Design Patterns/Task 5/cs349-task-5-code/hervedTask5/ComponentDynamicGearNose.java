public class ComponentDynamicGearNose extends A_ComponentDynamicGear {

   public ComponentDynamicGearNose(DescriptorComponent descriptor) {
   
      super(descriptor);
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append("<gear-nose>\n");
      getDescriptor().visit_(visitor);
      visitor.append("</gear-nose>\n");
   }
}