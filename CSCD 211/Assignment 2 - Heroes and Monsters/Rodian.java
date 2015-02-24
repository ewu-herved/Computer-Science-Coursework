//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

import java.util.*;

public class Rodian extends Monster {

   public Rodian() {
   
      name = generateName();
      hitPoints = 100;
      maxHP = 100;
      attackSpeed = 3;
      hitChance = .8;
      damageRange[0] = 30;
      damageRange[1] = 50;
      healChance = .3;
      healAmount[0] = 30;
      healAmount[1] = 50;
      abilityChance = .4;
   }
   
   private String generateName() { //generates name
            
      String[] names = {"Doda Bodonawieedo", "Wee Dunn", "Mahtee Dunn", "Onaconda Farr", 
      "Lolo Purs", "Feeven", "Jannik", "Menndo", "Hako Armado", "Jakoli", "Greedo", 
      "Greedo the Elder", "Ganodi", "Andoorni Hui", "Hulas", "Greeata Jendowanian",
      "Navik the Red", "Neesh", "Drexl Roosh", "Bolla Ropal", "Suvam Tan", "Rei Reeven", 
      "Dar Wac", "W. Wald", "Silood", "Zooki"};
      
      Random dice = new Random();     
      
      return names[dice.nextInt(names.length)];  
   }
   
   protected int specialAttack() { //attack always hits for moderate damage
   
      System.out.println(name + " takes a carefully aimed shot.");
      
      return 35;
   }
}