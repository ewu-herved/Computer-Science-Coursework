public class ComponentDynamicFlap extends A_ComponentDynamic {

   public ComponentDynamicFlap(DescriptorComponent descriptor) {
   
      super(descriptor);
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append("<flap>\n");
      getDescriptor().visit_(visitor);
      visitor.append("</flap>\n");
   }
}