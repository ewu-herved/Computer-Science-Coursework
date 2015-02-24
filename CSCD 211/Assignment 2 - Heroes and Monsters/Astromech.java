//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

import java.util.*;

public class Astromech extends Hero {

   public Astromech() {
   
      hitPoints = 75;
      maxHP = 75;
      attackSpeed = 5;
      hitChance = .7;
      damageRange[0] = 25;
      damageRange[1] = 45;
      blockChance = .3;
      abilityName = "Repair self";
   }
   
   protected int specialAttack() { //same special attack as sorceress in instructions
   
      int[] heal = {20, 40};
      
      Random diceHeal = new Random();
      
      System.out.println(name + " repairs himself.");
      
      hitPoints += diceHeal.nextInt(heal[1] - heal[0]) + heal[0]; 
      
      return 0;
   }
}