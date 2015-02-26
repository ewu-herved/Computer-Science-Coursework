public class ComponentDynamicAileron extends A_ComponentDynamic {

   public ComponentDynamicAileron(DescriptorComponent descriptor) {
   
      super(descriptor);
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append("<aileron>\n");
      getDescriptor().visit_(visitor);
      visitor.append("</aileron>\n");
   }
}