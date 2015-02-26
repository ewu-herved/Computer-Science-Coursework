public class ComponentStaticAirplane extends A_ComponentStatic {

   private ComponentStaticFuselage fuselage;

   public ComponentStaticAirplane(DescriptorComponent descriptor,
                                  ComponentStaticFuselage fuselage) {
   
      super(descriptor);
      
      this.fuselage = fuselage;                               
   }
   
   public ComponentStaticFuselage getFuselage() {
   
      return fuselage;
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append("<airplane>\n");
      getDescriptor().visit_(visitor);
      fuselage.visit_(visitor);
      visitor.append("</airplane>\n");
   }
}