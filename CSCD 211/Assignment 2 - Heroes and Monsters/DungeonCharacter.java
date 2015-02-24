//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

import java.util.*;

public abstract class DungeonCharacter {

   protected String name;
   
   protected int hitPoints;
   
   protected int maxHP;
   
   protected int attackSpeed;
   
   protected int[] damageRange = new int[2];
   
   protected double hitChance;
   
   public DungeonCharacter() {
   
      this.name = name;
      
      this.hitPoints = hitPoints;
      
      this.maxHP = maxHP;
      
      this.attackSpeed = attackSpeed;
      
      this.damageRange = damageRange;
      
      this.hitChance = hitChance;
   }
   
   protected String getName() {
   
      return name;
   }
   
   protected int getHitPoints() {
   
      return hitPoints;
   }
   
   protected int getAttackSpeed() {
   
      return attackSpeed;
   }
   
   protected int[] getDamageRange() {
   
      return damageRange;
   }
   
   protected double getHitChance() {
   
      return hitChance;
   }
   
   protected void setName(String name) {
   
      this.name = name;
   }
   
   protected void setHitPoints(int hitPoints) {
   
      this.hitPoints = hitPoints;
   }
   
   protected void setAttackSpeed(int attackSpeed) {
   
      this.attackSpeed = attackSpeed;
   }
   
   protected void setDamageRange(int minDamage, int maxDamage) {
   
      damageRange[0] = minDamage;
      
      damageRange[1] = maxDamage;
   }
   
   protected void setHitChance(double hitChance) {
   
      this.hitChance = hitChance;
   }
   
   protected int attack() { //attack method
   
      Random diceHit = new Random();
      
      Random diceDamage = new Random();
      
      double contact = diceHit.nextInt(100) / 100.0;
      
      System.out.println(name + " attacks!");
      
      if (diceHit.nextInt(100) / 100.0 < hitChance) {
      
         System.out.println(name + " lands a staggering blow.");
         
         int checkDam = diceDamage.nextInt(damageRange[1] - damageRange[0]) + damageRange[0];
      
         return diceDamage.nextInt(damageRange[1] - damageRange[0]) + damageRange[0];
      }
      
      else {
         
         System.out.println("The attack missed.");
      }
      
      return 0;
   }                 
}