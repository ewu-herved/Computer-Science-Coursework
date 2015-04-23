package s15cscd580task2;

import java.util.*;

import cs480viewer.task2.Agent;
import cs480viewer.task2.AgentManager;
import cs480viewer.task2.E_TrackMode;
import cs480viewer.task2.Viewer;

//=============================================================================================================================================================
public class CS480Task2Driver
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(final String[] args)
   {
      new CS480Task2Driver();
   }

   private final Viewer _viewer;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public CS480Task2Driver()
   {
      _viewer = new Viewer("track2_.trk", 100); // changed for Task 2 Version B; the update delay used to be in doAdvanceEventClock()

      doTest1();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void doTest1()
   {
      // this block provides control over displaying individual tracks; use the T key to toggle all on and off simultaneously. It applies to record mode only;
      // your settings are not retained for grading
      // {
      AgentManager agentManager = _viewer.getAgentManager();

      Agent agentDolphin = agentManager.getAgent("dolphin");

      agentDolphin.setTrackMode(E_TrackMode.HORIZONTAL_VERTICAL);
      // }
      
      Random randomGen = RandomGen.getInstance().getRandom();
      
      Map<String, Trajectory> entities = new HashMap<>();
      
      entities.put("dolphin", new Trajectory(new Triple((double)(randomGen.nextInt() % 500.0), 0.0, (double)(randomGen.nextInt() % 500.0)), 15, new Triple(500.0, 0.0, 500.0)));
      entities.put("fish1", new Trajectory(new Triple((double)(randomGen.nextInt() % 500.0), 0.0, (double)(randomGen.nextInt() % 500.0)), 10, new Triple(500.0, 0.0, 500.0)));
      entities.put("fish2", new Trajectory(new Triple((double)(randomGen.nextInt() % 500.0), 0.0, (double)(randomGen.nextInt() % 500.0)), 10, new Triple(500.0, 0.0, 500.0)));
      entities.put("fish3", new Trajectory(new Triple((double)(randomGen.nextInt() % 500.0), 0.0, (double)(randomGen.nextInt() % 500.0)), 10, new Triple(500.0, 0.0, 500.0)));
      entities.put("fish4", new Trajectory(new Triple((double)(randomGen.nextInt() % 500.0), 0.0, (double)(randomGen.nextInt() % 500.0)), 10, new Triple(500.0, 0.0, 500.0)));
      entities.put("fish5", new Trajectory(new Triple((double)(randomGen.nextInt() % 500.0), 0.0, (double)(randomGen.nextInt() % 500.0)), 10, new Triple(500.0, 0.0, 500.0)));

      for (int i = 0; i < 3000; i++)
      {
    	  
    	  Triple orientation = Pathing.orient(entities.get("dolphin").getCurr(), entities.get("dolphin").getDest());
         _viewer.doAddEvent("dolphin", entities.get("dolphin").getCurr().getX(), 
        		 					   entities.get("dolphin").getCurr().getY(),
        		 					   entities.get("dolphin").getCurr().getZ(), orientation.getX(), 0, 0);
         
         orientation = Pathing.orient(entities.get("fish1").getCurr(), entities.get("fish1").getDest());
         _viewer.doAddEvent("fish1", entities.get("fish1").getCurr().getX(), 
				   					 entities.get("fish1").getCurr().getY(),
				   					 entities.get("fish1").getCurr().getZ(), orientation.getX(), 0, 0);
         
         orientation = Pathing.orient(entities.get("fish2").getCurr(), entities.get("fish2").getDest());
         _viewer.doAddEvent("fish2", entities.get("fish2").getCurr().getX(), 
				   					 entities.get("fish2").getCurr().getY(),
				   					 entities.get("fish2").getCurr().getZ(), orientation.getX(), 0, 0);
         
         orientation = Pathing.orient(entities.get("fish3").getCurr(), entities.get("fish3").getDest());
         _viewer.doAddEvent("fish3", entities.get("fish3").getCurr().getX(), 
				   					 entities.get("fish3").getCurr().getY(),
				   					 entities.get("fish3").getCurr().getZ(), orientation.getX(), 0, 0);
         
         orientation = Pathing.orient(entities.get("fish4").getCurr(), entities.get("fish4").getDest());
         _viewer.doAddEvent("fish4", entities.get("fish4").getCurr().getX(), 
				   					 entities.get("fish4").getCurr().getY(),
				   					 entities.get("fish4").getCurr().getZ(), orientation.getX(), 0, 0);
         
         orientation = Pathing.orient(entities.get("fish5").getCurr(), entities.get("fish5").getDest());
         _viewer.doAddEvent("fish5", entities.get("fish5").getCurr().getX(), 
				   					 entities.get("fish5").getCurr().getY(),
				   					 entities.get("fish5").getCurr().getZ(), orientation.getX(), 0, 0);
         
         _viewer.doAdvanceEventClock(); // changed for Task 2 Version B; if you don't call this, nothing will update
         
         entities.get("dolphin").update();
         entities.get("fish1").update();
         entities.get("fish2").update();
         entities.get("fish3").update();
         entities.get("fish4").update();
         entities.get("fish5").update();
         
         entities.get("dolphin").jump();
         entities.get("fish1").collisionDetect(entities, "fish1");
         entities.get("fish2").collisionDetect(entities, "fish2");
         entities.get("fish3").collisionDetect(entities, "fish3");
         entities.get("fish4").collisionDetect(entities, "fish4");
         entities.get("fish5").collisionDetect(entities, "fish5");
      }
   }
}
