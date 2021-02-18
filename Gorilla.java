public class Gorilla extends Mammal {
  public Gorilla() {
    // Directly Call the Mammal Constructor
    super("gorilla", 500);
  }

  public void eatBanana() {
    System.out.printf("I am a %s eating a banana\n", this.species);
    this.health++;
  }

  @Override
  public void takeDamage(int damageAmount) {
    this.health -= (damageAmount / 2);
  }
}