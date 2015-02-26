//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

import java.util.*;

public class Jawa extends Monster {

   public Jawa() {
   
      name = generateName();
      hitPoints = 70;
      maxHP = 70;
      attackSpeed = 5;
      hitChance = .8;
      damageRange[0] = 15;
      damageRange[1] = 30;
      healChance = .4;
      healAmount[0] = 20;
      healAmount[1] = 40;
      abilityChance = .3;
   }
   
   private String generateName() { //generates name
            
      String[] names = {"Akkik", "Klepti B'ay", "Tteel Kkak", "Ttekket", "Het Nkik", "Wittin", 
      "Dathcha", "R'kik D'nec", "Herat", "Iasa", "Jik'Tal", "Kalit", "Kiottja", "Aved Luun",
      "Nebit", "Jek Nkik", "Khea Nkuul", "Thedit", "Wimateeka", "Iziz", "Fred Jawa", "Stan", "Blizz"};
      
      Random dice = new Random();     
      
      return names[dice.nextInt(names.length)];  
   }
   
   protected int specialAttack() { //attack has a chance to instantly kill both player and jawa if jawa's health is low
   
      Random hitDice = new Random();
      
      if (hitPoints < 30) {
      
         System.out.println("In an act of desperation, " + name + " pulls out a thermal detonator and charges! Uteeni!!!");
         
         if (hitDice.nextInt(100) / 100.0 < .6) {
         
            System.out.println("The last thing you see is " + name + "'s frenzied yellow eyes bearing down " +
            "like a train erupting from a tunnel.");
            
            hitPoints = 0;
            
            return 200;
         }
         else { 
            
            System.out.println(name + " misses his mark. The resulting explosion throws you a ways, but you were not harmed.");
            
            hitPoints = 0;
            
            return 0;
         }
      }
                  
      return attack();               
   }
}