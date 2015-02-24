//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

import java.util.*;

public class Wampa extends Monster {

   public Wampa() {
   
      name = generateName();
      hitPoints = 200;
      maxHP = 200;
      attackSpeed = 2;
      hitChance = .6;
      damageRange[0] = 30;
      damageRange[1] = 60;
      healChance = .1;
      healAmount[0] = 30;
      healAmount[1] = 60;
      abilityChance = .5;
   }
   
   private String generateName() { //generates name
            
      String[] names = {"Ujooku", "White Terror", "Unkajo", "Ku-Kak", "One-Arm"};
      
      Random dice = new Random();     
      
      return names[dice.nextInt(names.length)];  
   }
   
   protected int specialAttack() { //special attack procs multiple times if it hits
   
      Random dice = new Random();
      
      int[] abilityDamage = {20, 30}; 
      
      System.out.println(name + " bears down on you with raking claws!");
      
      int damage = 0;
      
      if (dice.nextInt(100) / 100.0 < .6) {
      
         System.out.println(name + " lands a flesh-rending blow.");
         
         damage = dice.nextInt(abilityDamage[1] - abilityDamage[0]) + abilityDamage[0];
         
         if (dice.nextInt(100) / 100.0 < .8) {
         
            System.out.println(name + " strikes again, to grizzly effect.");
         
            damage += dice.nextInt(abilityDamage[1] - abilityDamage[0]) + abilityDamage[0];
         }
         
         else {
         
            System.out.println(name + " strikes again, but misses");
         }
         
         if (dice.nextInt(100) / 100.0 < .8) {
         
            System.out.println(name + " strikes again, tearing much flesh.");
         
            damage += dice.nextInt(abilityDamage[1] - abilityDamage[0]) + abilityDamage[0];
         }
         
         else {
         
            System.out.println(name + " strikes again, but misses");
         }
         
         if (dice.nextInt(100) / 100.0 < .8) {
         
            System.out.println(name + " strikes again, reveling in his bloodlust.");
         
            damage += dice.nextInt(abilityDamage[1] - abilityDamage[0]) + abilityDamage[0];
         }
         
         else {
         
            System.out.println(name + " strikes again, but misses");
         }
         
         return damage;
      }
      
      else {
         
         System.out.println(name + "'s furious onslaught was skillfully dodged.");
      }
      
      return 0;
   }
}