public class ComponentStaticFuselage extends A_ComponentStatic {

   private ComponentStaticWingLeft wingLeft;
   private ComponentStaticWingRight wingRight;
   private ComponentStaticStabilizerHorizontal stabilizerLeft;
   private ComponentStaticStabilizerHorizontal stabilizerRight;
   private ComponentStaticStabilizerVertical stabilizerVertical;
   private ComponentDynamicGearNose gear;
   
   private EngineManager engineManager = new EngineManager(this);

   public ComponentStaticFuselage(DescriptorComponent descriptor,
                                  ComponentStaticWingLeft wingLeft,
                                  ComponentStaticWingRight wingRight,
                                  ComponentStaticStabilizerHorizontal stabilizerLeft,
                                  ComponentStaticStabilizerHorizontal stabilizerRight,
                                  ComponentStaticStabilizerVertical stabilizerVertical,
                                  ComponentDynamicGearNose gear) {
                                  
      super(descriptor);
      
      this.wingLeft = wingLeft;
      this.wingRight = wingRight;
      this.stabilizerLeft = stabilizerLeft;
      this.stabilizerRight = stabilizerRight;
      this.stabilizerVertical = stabilizerVertical;
      this.gear = gear;      
   }
   
   public ComponentDynamicGearNose getGear() {
   
      return gear;
   }
   
   public ComponentStaticStabilizerHorizontal getStabilizerLeft() {
   
      return stabilizerLeft;
   }
   
   public ComponentStaticStabilizerHorizontal getStabilizerRight() {
   
      return stabilizerRight;
   }
   
   public ComponentStaticStabilizerVertical getStabilizerVertical() {
   
      return stabilizerVertical;
   }
   
   public ComponentStaticWingLeft getWingLeft() {
   
      return wingLeft;
   }
   
   public ComponentStaticWingRight getWingRight() {
   
      return wingRight;
   }
   
   public EngineManager getEngineManager() {
   
      return engineManager;
   }
   
   @Override
   public void visit_(Visitor visitor) {
      
      visitor.append("<fuselage>\n");
      getDescriptor().visit_(visitor);
      wingLeft.visit_(visitor);
      wingRight.visit_(visitor);
      stabilizerLeft.visit_(visitor);
      stabilizerRight.visit_(visitor);
      stabilizerVertical.visit_(visitor);
      gear.visit_(visitor);
      visitor.append("</fuselage>\n");
   }
}