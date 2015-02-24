public class IdentifierSaltManager {

   private static IdentifierSaltManager _instance = null;
   
   private int iterator = 1;
   
   private IdentifierSaltManager(){}
   
   public static IdentifierSaltManager getInstance() {
   
      if (_instance == null)
         _instance = new IdentifierSaltManager();
         
      return _instance;
   }
   
   public String getIDSalted(String id) {
   
      id = id + "#" + iterator;
      
      iterator++;
      
      return id;
   }
   
   public String getSaltNext() {
   
      return "#" + iterator;
   }
}