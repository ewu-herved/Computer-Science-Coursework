public class Tester {

   public static void main(String[] args) {
   
      Entity ghost = new EntityGhost("Casper");
      Entity dog = new EntityDawg("Fido");
      Entity tree = new EntityTree("Beech");
      Entity cat = new EntityCat("Tom");
      Entity alien = new EntityAlien("Yoda");
      
      dog.initiateAttack(ghost);
      ghost.initiateAttack(tree);
      ghost.initiateAttack(alien);
      tree.move();
      tree.initiateAttack(dog);
      alien.move();
      alien.initiateAttack(ghost);
      cat.initiateAttack(alien);
      dog.initiateAttack(cat);
   }
}
