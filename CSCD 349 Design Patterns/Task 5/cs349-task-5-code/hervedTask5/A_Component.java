abstract class A_Component implements I_Visitable, I_Identifiable {

   private String id;
   
   private DescriptorComponent descriptor;
   
   private A_Component host;
   
   public A_Component(DescriptorComponent descriptor) {
   
      id = descriptor.getID_();
      
      this.descriptor = descriptor;
   }
   
   public DescriptorComponent getDescriptor() {
   
      return descriptor;
   }
   
   public String getID_() {
   
      return id;
   }
   
   public void setHost(A_Component host) {
   
      this.host = host;
   }
   
   public A_Component getHost() {
   
      return host;
   }
   
   public boolean hasHost() {
   
      if(host != null)
         return true;
      
      return false;
   }
   
   public void visit_(Visitor visitor) {
      
      visitor.append("<component>\n");
      descriptor.visit_(visitor);
      visitor.append("/component>\n");
   }
}