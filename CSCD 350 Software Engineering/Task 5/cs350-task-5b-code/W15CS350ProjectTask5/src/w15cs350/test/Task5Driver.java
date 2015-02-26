package w15cs350.test;

import java.util.ArrayList;
import java.util.List;

import w15cs350.datatype.Dimensions;
import w15cs350.datatype.Position;
import w15cs350.entity.component.A_Component;
import w15cs350.entity.component.ComponentBox;
import w15cs350.entity.component.DescriptorSpatial;
import w15cs350.entity.connector.LinkageBall;
import w15cs350.entity.connector.LinkageSocket;
import w15cs350.entity.connector.SpanStatic;
import w15cs350.machine.MachineGeneric;

//=============================================================================================================================================================
/**
 * Defines the driver for CS 350 Task 5.
 * 
 * @author Dan Tappan [11.01.15]
 */
public class Task5Driver
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * zzz
    * 
    * @param arguments - there are no arguments
    */
   public static void main(final String[] arguments)
   {
      Task5Driver driver = new Task5Driver();

      driver.runDynamicTest();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * zzz
    */
   private void runDynamicTest()
   {
      System.out.println("*** BEGIN ***\n\n");
      
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      // <skip> the trace of this part because it is the same as for component2 below
      String id1 = "component1";

      Dimensions dimensions1 = new Dimensions(4, 3, 2);

      Position pivot1 = Position.CENTER;

      DescriptorSpatial descriptor1 = new DescriptorSpatial(dimensions1, pivot1);

      List<LinkageSocket> sockets1 = new ArrayList<>();

      LinkageSocket component1Socket1 = new LinkageSocket("c1.s1", new Position(0, 1.5, 1));

      sockets1.add(component1Socket1);

      ComponentBox component1 = new ComponentBox(id1, descriptor1, sockets1, true);
      // </skip>

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      String id2 = "component2";

      Dimensions dimensions2 = new Dimensions(4, 3, 2);

      Position pivot2 = Position.CENTER;

      DescriptorSpatial descriptor2 = new DescriptorSpatial(dimensions2, pivot2);

      List<LinkageSocket> sockets2 = new ArrayList<>();

      LinkageSocket component2Socket1 = new LinkageSocket("c2.s1", new Position(0, 1.5, 1));

      sockets2.add(component2Socket1);

      ComponentBox component2 = new ComponentBox(id2, descriptor2, sockets2);

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      LinkageBall linkage1Ball1 = new LinkageBall("l1.b1", LinkageBall.E_Freedom.FIXED);
      LinkageBall linkage1Ball2 = new LinkageBall("l1.b2", LinkageBall.E_Freedom.FIXED);

      SpanStatic span1 = new SpanStatic("span1", linkage1Ball1, linkage1Ball2);

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      span1.bindToSockets(component1Socket1, component2Socket1);

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      List<A_Component> components = new ArrayList<>();

      components.add(component1);
      components.add(component2);

      MachineGeneric machine = new MachineGeneric("myMachine", components); 
      
      System.out.println(machine.toXML_()); // skip this statement
      
      System.out.println("\n\n*** END ***");
   }
}
