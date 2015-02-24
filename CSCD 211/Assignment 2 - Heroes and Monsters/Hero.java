//Dan Herve
//Assignment 2: Heroes and Monsters
//No known shortcomings; attempted extra class extra credit and monster abilities extra credit

public abstract class Hero extends DungeonCharacter {

   protected double blockChance;
   
   protected int turns;
   
   protected String abilityName;
   
   public Hero() {
   
      this.name = name;
      this.hitPoints = hitPoints;
      this.maxHP = maxHP;
      this.attackSpeed = attackSpeed;
      this.damageRange = damageRange;
      this.hitChance = hitChance;      
      this.blockChance = blockChance;
      this.abilityName = abilityName;
   }
   
   protected void userName(String name) {
      
      this.name = name;
   }
   
   protected double getBlockChance() {
   
      return blockChance;
   }
   
   protected int getTurns() {
   
      return turns;
   }
   
   protected String getAbilityName() {
   
      return abilityName;
   }
   
   protected void setBlockChance(double blockChance) {
   
      this.blockChance = blockChance; 
   }
   
   protected void setTurns(int turns) {
   
      this.turns = turns; 
   }
   
   protected void setAbilityName(String abilityName) {
   
      this.abilityName = abilityName;
   }
   
   protected abstract int specialAttack();
}
   
   