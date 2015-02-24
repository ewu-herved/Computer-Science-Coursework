//Dan Herve
//Assignment 1: Review
//No known shortcomings

public class Address { //class name

   private String street;
   
   private String city;
   
   private String state;
   
   private String zip;
   
   public Address(String street, String city, String state, String zip) { //evc
   
      this.street = street;
      
      this.city = city;
      
      this.state = state;
      
      this.zip = zip;
   }
   
   public String getStreet() {
   
      return street;
   }
   
   public String getCity() {
   
      return city;
   }
   
   public String getState() {
   
      return state;
   }
   
   public String getZip() {
   
      return zip;
   }
   
   public void setStreet(String street) {
   
      this.street = street;
   }
   
   public void setCity(String city) {
   
      this.city = city;
   }
   
   public void setState(String state) {
   
      this.state = state;
   }
   
   public void setZip(String zip) {
   
      this.zip = zip;
   }
   
   @Override
   public String toString() {
   
      return street + "\n" + city + ", " + state + "  " + zip + "\n";
   }
}