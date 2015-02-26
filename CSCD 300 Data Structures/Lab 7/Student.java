public class Student implements Comparable<Student> {

   int id;
   String name;
   
   public Student(int id, String name) {
   
      this.id = id; this.name = name;
   }
   
   @Override
   public int compareTo(Student that) {
   
      return this.id - that.id;
   }
   
   @Override
   public String toString() {
   
      if(id / 10 < 1) {
      
         return String.format("(000%d,%s)", id, name);
      }
      
      else if(id / 100 < 1) {
      
         return String.format("(00%d,%s)", id, name);
      }
      
      else if(id / 1000 < 1) {
      
         return String.format("(0%d,%s)", id, name);
      }
   
      return String.format("(%d,%s)", id, name);
   }
   
   public String toString2() {
   
      if(id / 10 < 1) {
      
         return String.format("Student id:000%d. Student name:%s", id, name);
      }
      
      else if(id / 100 < 1) {
      
         return String.format("Student id:00%d. Student name:%s", id, name);
      }
      
      else if(id / 1000 < 1) {
      
         return String.format("Student id:0%d. Student name:%s", id, name);
      }
   
      return String.format("Student id:%d. Student name:%s", id, name);
   }
}