import java.util.*;

public class ComponentStaticWingRight extends A_ComponentStaticWing {

   public ComponentStaticWingRight(DescriptorComponent descriptor,
                                  List<ComponentDynamicEngine> engines,
                                  List<ComponentDynamicAileron> ailerons,
                                  ComponentDynamicFlap flap,
                                  ComponentDynamicGearMain gear) {
                                
      super(descriptor, engines, ailerons, flap, gear);
   }
}