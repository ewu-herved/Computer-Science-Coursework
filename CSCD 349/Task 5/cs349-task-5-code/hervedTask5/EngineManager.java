import java.util.*;

public class EngineManager {

   private ComponentStaticFuselage host;
   
   private List<ComponentDynamicEngine> rightEngines = new LinkedList<ComponentDynamicEngine>();
   
   private List<ComponentDynamicEngine> leftEngines = new LinkedList<ComponentDynamicEngine>();
   
   private boolean isCommitted = false; 
   
   public EngineManager(ComponentStaticFuselage host) {
   
      this.host = host;
   }
   
   public void registerEngineLeft(ComponentDynamicEngine engine) {
   
      if (isCommitted); //would throw exception here
      else 
         leftEngines.add(engine);
   }
   
   public void registerEngineRight(ComponentDynamicEngine engine) {
      
      if (isCommitted); //would throw exception here
      else 
         rightEngines.add(engine);
   }
   
   public List<ComponentDynamicEngine> getEngines() {
   
      List<ComponentDynamicEngine> engines = new LinkedList<ComponentDynamicEngine>();
      
      engines.addAll(rightEngines);
      engines.addAll(leftEngines);
      return engines;
   }
   
   public void commit() {
   
      if(host.getWingLeft().getEngines().size() != host.getWingRight().getEngines().size()) {
      
         throw new RuntimeException("Number of engines not balanced between wings\n");
      }
      
      for(int i = 0; i < host.getWingLeft().getEngines().size(); i++) {
      
         registerEngineLeft(host.getWingLeft().getEngines().get(i));
      }
      
      for(int i = 0; i < host.getWingRight().getEngines().size(); i++) {
      
         registerEngineRight(host.getWingRight().getEngines().get(i));
      }
      
      isCommitted = true;
   }
   
   public void setPower(double power) {
   
      for(int i = 0; i < leftEngines.size(); i++) {
      
         leftEngines.get(i).setPower(power);
      }
      
      for(int i = 0; i < rightEngines.size(); i++) {
      
         rightEngines.get(i).setPower(power);
      }
   }
}