import java.util.*;

public class ComponentStaticWingLeft extends A_ComponentStaticWing {

   public ComponentStaticWingLeft(DescriptorComponent descriptor,
                                  List<ComponentDynamicEngine> engines,
                                  List<ComponentDynamicAileron> ailerons,
                                  ComponentDynamicFlap flap,
                                  ComponentDynamicGearMain gear) {
                                
      super(descriptor, engines, ailerons, flap, gear);
   }
}