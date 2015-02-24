public abstract class Employee {

   protected String name;
   
   protected int salary = 40;
   
   protected String getName() {
   
      return name;
   }
   
   protected int getSalary() {
   
      return salary;
   }
   
   protected void setName(String name) {
   
      this.name = name;
   }
   
   protected void setSalary(int salary) {
   
      this.salary = salary;
   }
   
   protected abstract void reportSalary();
}