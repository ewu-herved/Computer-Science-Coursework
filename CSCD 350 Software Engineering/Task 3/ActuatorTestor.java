import w15cs350task3.*;

public class ActuatorTestor {

   public static void main(String[] args) {
   
      test1();
      
      test2();
      
      test3();
      
      test4();
      
      test5();
      
      test6();
      
      test7();
      
      test8();
      
      test9();
      
      test10();
      
      test11();
      
      test12();
      
      test13();
      
      test14();
   }
   
   private static int report(I_Actuator actuator, int event, boolean isDone) {
      
      System.out.println("Event " + event + " " + actuator.toString() + " Done=" + isDone);
      
      event++;
      
      return event;
   }
   
   private static void test1() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 1\n");
   
      I_Actuator linearUp = new MyActuatorLinear("linearUp", 10.0, 20.0, 3.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test2() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 2\n");
   
      I_Actuator linearUp = new MyActuatorLinear("linearDown", 10.0, -19.0, 3.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test3() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 3\n");   
   
      I_Actuator linearUp = new MyActuatorLinear("linearUpCancelMiddle", 10.0, 20.0, 3.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      linearUp.cancel_();
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test4() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 4\n");   
   
      I_Actuator linearUp = new MyActuatorLinear("linearDownCancelMiddle", 10.0, -21.0, 3.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      linearUp.cancel_();
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test5() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 5\n");
   
      I_Actuator linearUp = new MyActuatorLinear("linearUpTerminateMiddle", 10.0, 40.0, 3.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      linearUp.terminate_();
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test6() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 6\n");
   
      I_Actuator linearUp = new MyActuatorLinear("linearDownTerminateMiddle", 10.0, -25.0, 3.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      linearUp.terminate_();
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test7() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 7\n");   
   
      I_Actuator linearUp = new MyActuatorLinear("linearUpTerminateStart", 10.0, 25.0, 3.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      linearUp.terminate_();
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test8() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 8\n");   
   
      I_Actuator linearUp = new MyActuatorLinear("linearDownTerminateStart", 10.0, -25.0, 3.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      linearUp.terminate_();
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test9() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 9\n");
   
      I_Actuator linearUp = new MyActuatorNonlinear("nonlinearUp", 10.0, 50.0, 1.0, 1.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test10() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 10\n");
   
      I_Actuator linearUp = new MyActuatorNonlinear("nonlinearDown", 10.0, -59.0, 1.0, 1.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test11() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 11\n");
   
      I_Actuator linearUp = new MyActuatorNonlinear("nonlinearUpCancelMiddle", 10.0, 50.0, 3.0, 2.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      linearUp.cancel_();
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test12() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 12\n");
   
      I_Actuator linearUp = new MyActuatorNonlinear("nonlinearDownCancelMiddle", 10.0, -51.0, 3.0, 2.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      linearUp.cancel_();
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test13() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 13\n");
   
      I_Actuator linearUp = new MyActuatorNonlinear("nonlinearUpTerminateMiddle", 10.0, 70.0, 3.0, 2.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);     
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      linearUp.terminate_();
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
   
   private static void test14() {
   
      int event = 0;
      
      boolean isDone = false;
      
      System.out.println("Test 14\n");
   
      I_Actuator linearUp = new MyActuatorNonlinear("nonlinearDownTerminateMiddle", 10.0, -55.0, 3.0, 2.0);
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);     
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      linearUp.terminate_();
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      isDone = linearUp.updateState_();     
      
      event = report(linearUp, event, isDone);
      
      System.out.println();
   }
}