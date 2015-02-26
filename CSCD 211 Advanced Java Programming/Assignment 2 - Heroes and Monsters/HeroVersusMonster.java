//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

import java.util.*;

public class HeroVersusMonster {

   private static Scanner input = new Scanner(System.in); //Scanner for user prompts
   
   private static Hero player;
   
   private static Monster adversary;
   
   private static int killCount = 0;
   
   public static void main(String[] args) { //Main method
   
      int repeat = 0; //sentinal checks whether player still lives
      
      getActors(); //prompts player to pick class and generates first enemy
      
      while (repeat == 0) {         
         
         boolean continueInput = true;
         
         int choice = 0;
         
         bout();
         
         if (player.hitPoints <= 0) {
         
            repeat = 1;
            break;
         }  
               
         do { 
         
            try {
            
               while (choice != 2 && player.hitPoints > 0) { //Prompts the user to continue after slaying a foe
               
                  System.out.println("Would like like to seek another foe?\n\n1. Yes\n2. No\n");
         
                  choice = input.nextInt();
            
                  switch (choice) {
         
                     case 1: System.out.println("You survey the area for nefarious scum...\n");
                             pickAdversary();
                             bout();
                             break;
                    
                     case 2: repeat = 1;
                             System.out.println("You retire for the day.");
                             
                             if (killCount > 1) {
                             
                                System.out.print("You have slain " + killCount + " foes!");
                             }
                             
                             if (killCount > 0) {
                             
                                System.out.print("You have slain " + killCount + " foe!");
                             }
                             break;
                  }             
               }
               
               continueInput = false;
            }
         
            catch (InputMismatchException ex) {
         
               System.out.println("That is not a valid choice.");
               
               input.nextLine();
            }
         } while(continueInput);
      }
   }
   
   private static void getActors() { //prompts user to select class and generates first enemy
   
      int choice = 0; 
      
      boolean continueInput = true;     
      
      do {
      
         try {          
            
            while (choice < 1 || choice > 4) {
            
               System.out.println("Choose your hero: \n1: Wookie\n2: Smuggler\n3: Astromech Droid\n4: Princess");
               
               choice = Integer.parseInt(input.nextLine());
               
               switch (choice) {
               
                  case 1: player = new Wookie();
                          break;
                  
                  case 2: player = new Smuggler();
                          break;
                  
                  case 3: player = new Astromech();
                          break;
                          
                  case 4: player = new Princess();
                          break;
               }               
               
               if (choice < 0 || choice > 4) {
                  
                  System.out.println("That is not a valid hero option.\nPlease enter a valid hero option.");
               }             
            }
            
            System.out.print("What is the name of your hero?: ");
            
            player.setName(input.nextLine());
            
            System.out.println();
            
            continueInput = false;       
         }
      
         catch (InputMismatchException ex) {
      
            System.out.println(choice + " is not a valid hero option.\nPlease enter a valid hero option.");
            
            input.nextLine();
         }
      
         pickAdversary();
      } while (continueInput);
   }
   
   private static void pickAdversary() { //generates enemies
   
      Random pickAdversary = new Random();
            
      int adversaryChoice = pickAdversary.nextInt(3);
            
      switch (adversaryChoice) {
            
         case 0: adversary = new Rodian();
                 break;
               
         case 1: adversary = new Jawa();
                 break;
               
         case 2: adversary = new Wampa();
                 break;
      }
   }     
   
   private static void bout() { //combat method
   
      int choice = 0;      
      
      int roundDamage;
      
      while ((player.hitPoints > 0 && adversary.hitPoints > 0) && choice != 3) {
      
         boolean continueInput = true;
         
         do {
         
            try { //combat menu
            
               System.out.println(adversary.name + " the " + adversary.getClass().getName() + 
               " squares against you. What do you do?\n\n1: Attack\n2: " + player.getAbilityName() +
               "\n3: Flee\n");
               
               choice = input.nextInt();            
               
               switch (choice) {               
                     
                  case 1: roundDamage = player.attack();
                          adversary.hitPoints -= roundDamage;
                          if (roundDamage > 0 && adversary.hitPoints > 0) {
                             adversary.selfHeal();
                          } 
                          break;
                     
                  case 2: roundDamage = player.specialAttack();
                          adversary.hitPoints -= roundDamage;
                          if (roundDamage > 0 && adversary.hitPoints > 0) {
                             adversary.selfHeal();
                          }
                          break;
                     
                  case 3: System.out.println("You make a tactical retreat.");
                          break;
               }            
                  
               if (choice <=0 || choice > 3) {
                  
                  System.out.println("That is not a valid choice");
               }
               
               continueInput = false;
            }
               
            catch (InputMismatchException ex) {
               
               System.out.println("That is not a valid choice");
               
               input.nextLine();
            }        
         
            if (choice != 3 && choice != 0) { //enemy attack code
            
               if (adversary.hitPoints > 0) {
            
                  Random diceHit = new Random();                  
               
                  if (diceHit.nextInt(100) / 100.0 > player.blockChance) {
               
                     if (diceHit.nextInt(100) / 100.0 < adversary.abilityChance) {
                     
                        player.hitPoints -= adversary.specialAttack();
                     }
                     
                     else {
                     
                        int damage = adversary.attack();
                     
                        player.hitPoints -= damage;
                  
                        if (damage > 0) {
                     
                           System.out.println(adversary.name + " wounds the mighty " + player.name + ".");
                        }
                     }
                  }
               
                  else {
                  
                     System.out.println(adversary.name + " attacks!");
               
                     System.out.println(player.name + " deftly blocked " + adversary.name + "'s attack.");
                  }
               }
            
               if (player.hitPoints == player.maxHP) { //text indicates the status of the player's hitpoints
               }
            
               else if (player.hitPoints <= 0) {
         
                  System.out.println("\n" + player.name + " is defeated, " + checkGender() + " crusade for love and justice" + 
                  " tragically cut short.");
                  
                  if (killCount > 1) {
                             
                     System.out.print("You have slain " + killCount + " foes!");
                  }
                             
                  else if (killCount > 0) {
                             
                     System.out.print("You have slain " + killCount + " foe!");
                  }
               }
         
               else if (player.hitPoints > 0 && player.hitPoints <= 30 && adversary.hitPoints > 0) {
            
                  System.out.println(player.name + " is mortally wounded.");
               }
         
               else if (player.hitPoints > 30 && player.hitPoints <= 60 && adversary.hitPoints > 0) {
            
                  System.out.println(player.name + " is limping from " + checkGender() + " wounds.");
               }
               
               else if (player.hitPoints > 60 && player.hitPoints <= 90 && adversary.hitPoints > 0) {
                  
                     System.out.println(player.name + " looks worn from battle.");
                  }
            
               if (player.hitPoints > 0 && adversary.hitPoints > 0) { //code for additional attacks based on attack speed
               
                  for (int i = 1; i < (player.attackSpeed / adversary.attackSpeed); i++) {
               
                     roundDamage = player.attack();
                  
                     adversary.hitPoints -= roundDamage;
                             
                     if (roundDamage > 0) {
                                
                        adversary.selfHeal();
                     }            
                  }
               }
               
               if (player.hitPoints > 0) { //text indicates the health of the enemy
               
                  if (adversary.hitPoints == adversary.maxHP) {
               
                     System.out.println(adversary.name + " mocks you with a sardonic glare.");
                  }
               
                  else if (adversary.hitPoints <= 0) {
               
                     killCount++;
                     
                     System.out.println(adversary.name + " is defeated, and marinates in his puddle of blood.");
                  }
               
                  else if (adversary.hitPoints > 0 && adversary.hitPoints <= 30) {
                  
                     System.out.println(adversary.name + " is mortally wounded.");
                  }
               
                  else if (adversary.hitPoints > 30 && adversary.hitPoints <= 60) {
                  
                     System.out.println(adversary.name + " is limping from his wounds.");
                  }
                  
                  else if (adversary.hitPoints > 60 && adversary.hitPoints <= 90) {
                  
                     System.out.println(adversary.name + " looks worn from battle.");
                  }
               }
               
               System.out.println();                           
            }
         } while (continueInput);
      }   
   }
   
   private static String checkGender() { //checks gender of class
   
      if (player.getClass().getName().equals("Princess")) {
      
         return "her";
      }
      
      return "his";
   }   
}  
