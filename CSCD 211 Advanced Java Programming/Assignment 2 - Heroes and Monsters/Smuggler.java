//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

import java.util.*;

public class Smuggler extends Hero {

   public Smuggler() {
   
      hitPoints = 75;
      maxHP = 75;
      attackSpeed = 6;
      hitChance = .8;
      damageRange[0] = 20;
      damageRange[1] = 40;
      blockChance = .4;
      abilityName = "Surprise Attack";
   }
   
   protected int specialAttack() { //same special attack as theif in instructions
   
      Random diceHit = new Random();
      
      Random diceDamage = new Random();
      
      double hitRoll = diceHit.nextInt(100) / 100.0;
      
      System.out.println(name + " readies a concealed weapon.");
      
      if (hitRoll < .4) {
      
         System.out.println(name + " connects with a devastating surprise assault.");
         
         return (diceDamage.nextInt(damageRange[1] - damageRange[0]) + damageRange[0]) +
                 diceDamage.nextInt(damageRange[1] - damageRange[0]) + damageRange[0];
      }
      
      else if (hitRoll >= .4 && hitRoll <= .8) {
      
         System.out.println(name + " missed his opportunity for surprise, but landed a worthy attack.");
         
         return diceDamage.nextInt(damageRange[1] - damageRange[0]) + damageRange[0];
      }
      
      else {
         
         System.out.println(name + " fumbled his cunning scheme.");
      }
      
      return 0;
   }
}