public class Student implements Comparable<Student> {

   private String name;
   
   private int studentID;
   
   private double gpa;
   
   public Student() {
   
   }
   
   public Student(String name, int studentID) {
   
      this.name = name;
      
      this.studentID = studentID;
      
      this.gpa = 0.0; 
   }
   
   public void setName(String name) {
   
      this.name = name;
   }
   
   public void setID(int studentID) {
   
      this.studentID = studentID;
   }
   
   public void setGPA(double gpa) {
   
      this.gpa = gpa;
   }
   
   public String getName() {
   
      return name;
   }
   
   public int getID() {
   
      return studentID;
   }
   
   public double getGPA() {
      
      return gpa;
   }
   
   @Override
   public String toString() {
   
      return "Name: " + name + "\n\nID: " + studentID + "\n\nGPA: " + gpa;
   }
   
   @Override
   public boolean equals(Object obj) {
   
      if (this.getClass().getSimpleName().equals(obj.getClass().getSimpleName())) {
      
         Student that = (Student)obj;
   
         if (this.studentID == that.studentID) {
      
            return true;
         }
      }
      
      return false;
   }
   
   @Override
   public int compareTo(Student that) {
   
      if (this.studentID == that.studentID) 
         
         return 0;
      
      return this.studentID - that.studentID;
   }
}
  