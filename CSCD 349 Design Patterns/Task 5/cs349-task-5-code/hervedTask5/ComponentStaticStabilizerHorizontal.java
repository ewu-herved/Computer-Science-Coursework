public class ComponentStaticStabilizerHorizontal extends A_ComponentStatic {

   private ComponentDynamicElevator elevator;
   
   public ComponentStaticStabilizerHorizontal(DescriptorComponent descriptor,
                                              ComponentDynamicElevator elevator) {
      
      super(descriptor);
      
      this.elevator = elevator;                                     
   }
   
   public ComponentDynamicElevator getElevator() {
   
      return elevator;
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append("<stabilizer-horizontal>\n");
      getDescriptor().visit_(visitor);
      elevator.visit_(visitor);
      visitor.append("</stabilizer-horizontal>\n");
   }   
}  