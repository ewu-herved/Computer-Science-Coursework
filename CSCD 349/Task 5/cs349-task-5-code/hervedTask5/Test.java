import java.util.ArrayList;
import java.util.List;

//=============================================================================================================================================================
public class Test
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(final String[] arguments)
   {
      assert (arguments != null);

      Test test = new Test();

      test.runTest1();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private DescriptorComponent build(final String id,
                                     final double x,
                                     final double y,
                                     final double z,
                                     final double height,
                                     final double width,
                                     final double depth)
   {
      DescriptorPositional position = new DescriptorPositional(x, y, z);

      DescriptorDimensional dimensions = new DescriptorDimensional(height, width, depth);

      DescriptorSpatial descriptorSpatial = new DescriptorSpatial(position, dimensions);

      DescriptorComponent descriptorComponent = new DescriptorComponent(id, descriptorSpatial);

      return descriptorComponent;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void runTest1()
   {
      System.out.println("Building...\n");

      // left wing
      // left wing engine(s)
      List<ComponentDynamicEngine> enginesLeft = new ArrayList<>();

      // left wing engine propeller
      ComponentDynamicPropeller propellerLeft = new ComponentDynamicPropeller(build("myLeftPropeller", 1, 2, 3, 4, 5, 6));

      enginesLeft.add(new ComponentDynamicEngine(build("myLeftEngine", 7, 8, 9, 10, 11, 12), propellerLeft));

      // left wing aileron(s)
      List<ComponentDynamicAileron> aileronsLeft = new ArrayList<>();

      aileronsLeft.add(new ComponentDynamicAileron(build("myLeftAileron", 13, 14, 15, 16, 17, 18)));

      // left wing flap
      ComponentDynamicFlap flapLeft = new ComponentDynamicFlap(build("myLeftFlap", 19, 20, 21, 22, 23, 24));

      // left wing gear
      ComponentDynamicGearMain gearLeft = new ComponentDynamicGearMain(build("myLeftGear", 25, 26, 27, 28, 29, 30));

      ComponentStaticWingLeft wingLeft = new ComponentStaticWingLeft(build("myLeftWing", 31, 32, 33, 34, 35, 36), enginesLeft, aileronsLeft, flapLeft, gearLeft);

      // right wing
      // right wing engine(s)
      List<ComponentDynamicEngine> enginesRight = new ArrayList<>();

      // right wing engine propeller
      ComponentDynamicPropeller propellerRight = new ComponentDynamicPropeller(build("myRightPropeller", 37, 38, 39, 40, 41, 42));

      enginesRight.add(new ComponentDynamicEngine(build("myRightEngine", 43, 44, 45, 46, 47, 48), propellerRight));

      // right wing aileron(s)
      List<ComponentDynamicAileron> aileronsRight = new ArrayList<>();

      aileronsRight.add(new ComponentDynamicAileron(build("myRightAileron", 49, 50, 51, 52, 53, 54)));

      // right wing flap
      ComponentDynamicFlap flapRight = new ComponentDynamicFlap(build("myRightFlap", 55, 56, 57, 58, 59, 60));

      // right wing gear
      ComponentDynamicGearMain gearRight = new ComponentDynamicGearMain(build("myRightGear", 61, 62, 63, 64, 65, 66));

      ComponentStaticWingRight wingRight = new ComponentStaticWingRight(build("myRightWing", 67, 68, 69, 70, 71, 72),
                                                                        enginesRight,
                                                                        aileronsRight,
                                                                        flapRight,
                                                                        gearRight);

      // left stabilizer elevator
      ComponentDynamicElevator elevatorLeft = new ComponentDynamicElevator(build("myLeftElevator", 73, 74, 75, 76, 77, 78));

      // left stabilizer
      ComponentStaticStabilizerHorizontal stabilizerLeft = new ComponentStaticStabilizerHorizontal(build("myLeftStabilizer", 79, 80, 81, 82, 83, 84),
                                                                                                   elevatorLeft);

      // right stabilizer elevator
      ComponentDynamicElevator elevatorRight = new ComponentDynamicElevator(build("myRightElevator", 85, 86, 87, 88, 89, 90));

      // right stabilizer
      ComponentStaticStabilizerHorizontal stabilizerRight = new ComponentStaticStabilizerHorizontal(build("myRightStabilizer", 91, 92, 93, 94, 95, 96),
                                                                                                    elevatorRight);

      // vertical stabilizer rudder
      ComponentDynamicRudder rudder = new ComponentDynamicRudder(build("myRudder", 97, 98, 99, 100, 101, 102));

      // vertical stabilizer
      ComponentStaticStabilizerVertical stabilizerVertical = new ComponentStaticStabilizerVertical(build("myVerticalStabilizer", 103, 104, 105, 106, 107, 108),
                                                                                                   rudder);

      // fuselage nose gear
      ComponentDynamicGearNose gear = new ComponentDynamicGearNose(build("myNoseGear", 109, 110, 111, 112, 113, 114));

      // fuselage
      ComponentStaticFuselage fuselage = new ComponentStaticFuselage(build("myFuselage", 115, 116, 117, 118, 119, 120),
                                                                     wingLeft,
                                                                     wingRight,
                                                                     stabilizerLeft,
                                                                     stabilizerRight,
                                                                     stabilizerVertical,
                                                                     gear);

      EngineManager engineManager = fuselage.getEngineManager();

      engineManager.commit();

      engineManager.setPower(50);

      // ** do visitation
      Visitor visitor = new Visitor();

      fuselage.visit_(visitor);

      System.out.println(visitor.getStream());
   }
}
