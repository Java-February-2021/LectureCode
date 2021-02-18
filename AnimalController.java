public class AnimalController {
  public static void main(String[] args) {
    Animal lion = new Animal("Larry", 10, "Carnivore", 30);
    Animal bear = new Animal("Benny", 10, "Carnivore", 25);

    lion.battle(bear, "roar");
    bear.battle(lion, "kick");

    Animal cat = new Animal("cesar", 10, "Carnivore", 40);
    cat.battle(lion);

  }
}