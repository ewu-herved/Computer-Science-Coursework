//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

import java.util.*;

public class Princess extends Hero {

   public Princess() {
   
      hitPoints = 70;
      maxHP = 70;
      attackSpeed = 4;
      hitChance = .7;
      damageRange[0] = 20;
      damageRange[1] = 50;
      blockChance = .45;
      abilityName = "Shout: \"You're!\" (Use successively to great effect.)";
   }
   
   protected int specialAttack() { //attack instantly slays foes if used 5 times in a row
   
      if (abilityName.equals("Shout: \"You're!\" (Use successively to great effect.)")) {
      
         setAbilityName("Shout: \"A!\" (Use successively to great effect.)");
      }
      
      else if (abilityName.equals("Shout: \"A!\" (Use successively to great effect.)")) {
      
         setAbilityName("Shout: \"Scruffy!\" (Use successively to great effect.)");
      }
      
      else if (abilityName.equals("Shout: \"Scruffy!\" (Use successively to great effect.)")) {
      
         setAbilityName("Shout: \"Nerf!\" (Use successively to great effect.)");
      }
      
      else if (abilityName.equals("Shout: \"Nerf!\" (Use successively to great effect.)")) {
      
         setAbilityName("Shout: \"Herder!\" (Use successively to great effect.)");
      }
      
      else if (abilityName.equals("Shout: \"Herder!\" (Use successively to great effect.)")) {
      
         setAbilityName("Shout: \"You're!\" (Use successively to great effect.)");
         
         System.out.println(name + "'s devastating oration melts her foe's resolve.");
         
         return 200;
      }   
      
      return 0;
   }
   
   @Override
   protected void setName(String name) { //modifies princess class's name with title
      
      this.name = "Princess " + name;
   }
}