public class ComponentDynamicElevator extends A_ComponentDynamic {

   public ComponentDynamicElevator(DescriptorComponent descriptor) {
   
      super(descriptor);
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append("<elevator>\n");
      getDescriptor().visit_(visitor);
      visitor.append("</elevator>\n");
   }
}