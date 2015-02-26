//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

import java.util.*;

public abstract class Monster extends DungeonCharacter {

   protected double healChance;
   
   protected int[] healAmount = new int[2];
   
   protected double abilityChance;
   
   public Monster() {
   
      this.name = name;
      this.hitPoints = hitPoints;
      this.maxHP = maxHP;
      this.attackSpeed = attackSpeed;
      this.damageRange = damageRange;
      this.hitChance = hitChance;
      this.healChance = healChance;
      this.healAmount = healAmount;
      this.abilityChance = abilityChance;
   }
   
   protected double getHealChance() {
   
      return healChance;
   }
   
   protected int[] getHealAmount() {
   
      return healAmount;
   }
   
   protected void setHealChance(double healChance) {
   
      this.healChance = healChance; 
   }
   
   protected void setHealAmount(int[] healAmount) {
   
      this.healAmount = healAmount; 
   }
   
   protected void selfHeal() { //code for chance for monsters to heal when struck
   
      Random healDie = new Random();
      
      Random healValue = new Random();
      
      double contact = (healDie.nextInt(100) + 1) / 100.0;
      
      if ((healDie.nextInt(100) + 1) / 100.0 < healChance && hitPoints != maxHP) {
               
         hitPoints += (healValue.nextInt(healAmount[1] - healAmount[0]) + healAmount[0]);
         
         if (hitPoints > maxHP) {
         
            hitPoints = maxHP;
         }
         
         System.out.println(name + " recovers somewhat.");
      }      
   }
   
   @Override
   protected int attack() { //modified attack for monsters
   
      Random diceHit = new Random();
      
      Random diceDamage = new Random();
      
      double contact = diceHit.nextInt(100) / 100.0;
      
      System.out.println(name + " attacks!");
      
      if (diceHit.nextInt(100) / 100.0 < hitChance) {
         
         int checkDam = diceDamage.nextInt(damageRange[1] - damageRange[0]) + damageRange[0];
      
         return diceDamage.nextInt(damageRange[1] - damageRange[0]) + damageRange[0];
      }
      
      else {
         
         System.out.println(name + "'s attack missed.");
      }
      
      return 0;
   }
         
   protected abstract int specialAttack();
}