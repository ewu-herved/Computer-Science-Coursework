//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

import java.util.*;

public class Wookie extends Hero {

   public Wookie() {
   
      hitPoints = 125;
      maxHP = 125;
      attackSpeed = 4;
      hitChance = .8;
      damageRange[0] = 35;
      damageRange[1] = 60;
      blockChance = .2;
      abilityName = "Crushing Blow";
   }
   
   protected int specialAttack() { //same special attack as warrior in instructions
   
      Random diceHit = new Random();
      
      Random diceDamage = new Random();
      
      System.out.println(name + " gathers all his rage into a devastating blow.");
      
      if (diceHit.nextInt(100) / 100.0 < .4) {
      
         System.out.println(name + " connects with unparalleled force.");
         
         return diceDamage.nextInt(100) + 75;
      }
      
      else {
         
         System.out.println("The attack missed.");
      }
      
      return 0;
   }
}