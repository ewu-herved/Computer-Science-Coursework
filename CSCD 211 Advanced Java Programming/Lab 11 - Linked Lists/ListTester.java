public class ListTester {

   public static void main(String[] args) {
   
      ListReferenceBased myList = new ListReferenceBased();
      
      for (int i = 1; i < 7; i++) {
      
         double temp;
         
         temp = 1.23456 * i;
         
         Double d = new Double(temp);
         
         myList.addNode(d);
      }
      
      System.out.println(myList);
      
      myList.removeNode(1);
      System.out.println(myList);
      
      Double d = new Double(99.0);
      myList.addNode(1, d);
      System.out.println(myList);
      
      myList.addNode(2, new Double(68));
      System.out.println(myList);
   }
}