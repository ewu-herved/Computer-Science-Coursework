public class ComponentDynamicRudder extends A_ComponentDynamic {

   public ComponentDynamicRudder(DescriptorComponent descriptor) {
   
      super(descriptor);
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append("<rudder>\n");
      getDescriptor().visit_(visitor);
      visitor.append("</rudder>\n");
   }
}