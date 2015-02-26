public class EmployeeList {

   public static void main(String[] args) {
   
      Lawyer lawyer1 = new Lawyer("Ivanna Killmen", 11);
      
      Lawyer lawyer2 = new Lawyer("Luke N. Dimm", 0);
      
      Lawyer lawyer3 = new Lawyer("Eileen Dover", 100);
      
      Accountant accountant1 = new Accountant("Bill Cheatum", 17.00);
       
      Accountant accountant2 = new Accountant("Joe Kisonyou", 45.50);
      
      Accountant accountant3 = new Accountant("Seymore Butts", 2.50);
      
      Programmer programmer1 = new Programmer("Dan Herve", false);
      
      Programmer programmer2 = new Programmer("Will E. Makeit", true);
   
      Employee[] employees = {lawyer1, lawyer2, lawyer3, accountant1, accountant2, accountant3,
      programmer1, programmer2};
      
      for (int i = 0; i < employees.length; i++) {
      
         System.out.print(employees[i].getName() + ": ");
         
         employees[i].reportSalary();
         
         System.out.println();
      }   
   }
}