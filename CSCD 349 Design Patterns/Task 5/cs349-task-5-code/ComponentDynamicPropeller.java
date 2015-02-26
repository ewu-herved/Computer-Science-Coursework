public class ComponentDynamicPropeller extends A_ComponentDynamic {

   public ComponentDynamicPropeller(DescriptorComponent descriptor) {
   
      super(descriptor);
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append("<propeller>\n");
      getDescriptor().visit_(visitor);
      visitor.append("</propeller>\n");
   }
}