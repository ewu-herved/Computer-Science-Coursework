public class ComponentDynamicEngine extends A_ComponentDynamic {

   private ComponentDynamicPropeller propeller;
   
   private double power;

   public ComponentDynamicEngine(DescriptorComponent descriptor, ComponentDynamicPropeller propeller) {
   
      super(descriptor);
      
      this.propeller = propeller;
   }
   
   public ComponentDynamicPropeller getPropeller() {
   
      return propeller;
   }
   
   public double getPower() {
   
      return power;
   }
   
   public void setPower(double power) {
   
      this.power = power;
      
      System.out.println("engine " + getID_() + " power at " + power + "\n");
   }
   
   @Override
   public void visit_(Visitor visitor) {
   
      visitor.append(("<engine power=" + power + ">\n"));
      getDescriptor().visit_(visitor);
      propeller.visit_(visitor);
      visitor.append("</engine>\n");
   }
}