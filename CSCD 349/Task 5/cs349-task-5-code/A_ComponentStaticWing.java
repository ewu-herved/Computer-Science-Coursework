import java.util.*;

abstract class A_ComponentStaticWing extends A_ComponentStatic {

   private List<ComponentDynamicEngine> engines;
   
   private List<ComponentDynamicAileron> ailerons;
   
   private ComponentDynamicFlap flap;
   
   private ComponentDynamicGearMain gear;
   
   public A_ComponentStaticWing(DescriptorComponent descriptor,
                                List<ComponentDynamicEngine> engines,
                                List<ComponentDynamicAileron> ailerons,
                                ComponentDynamicFlap flap,
                                ComponentDynamicGearMain gear) {
   
      super(descriptor);
      this.engines = engines;
      this.ailerons = ailerons;
      this.flap = flap;
      this.gear = gear;
   }
   
   public List<ComponentDynamicAileron> getAilerons() {
   
      return ailerons;
   }
   
   public List<ComponentDynamicEngine> getEngines() {
   
      return engines;
   }
   
   public ComponentDynamicFlap getFlap() {
   
      return flap;
   }
   
   public ComponentDynamicGearMain getGear() {
   
      return gear;
   }
   
   @Override   
   public void visit_(Visitor visitor) {
   
      visitor.append("<wing>\n");
      getDescriptor().visit_(visitor);
      for(int i = 0; i < engines.size(); i++) {
      
         engines.get(i).visit_(visitor);
      }
      for(int i = 0; i < ailerons.size(); i++) {
      
         ailerons.get(i).visit_(visitor);
      }
      flap.visit_(visitor);
      gear.visit_(visitor);
      visitor.append("</wing>\n");
   }
}
  
  