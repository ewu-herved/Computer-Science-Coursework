public class ComponentStaticStabilizerVertical extends A_ComponentStatic {

   private ComponentDynamicRudder rudder;
   
   public ComponentStaticStabilizerVertical(DescriptorComponent descriptor,
                                        ComponentDynamicRudder rudder) {
      super(descriptor);
      this.rudder = rudder;                                     
   }
   
   public ComponentDynamicRudder getRudder() {
   
      return rudder;
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append("<stabilizer-vertical>\n");
      getDescriptor().visit_(visitor);
      rudder.visit_(visitor);
      visitor.append("</stabilizer-vertical>\n");
   }
}  