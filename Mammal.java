import jdk.jfr.DataAmount;

public class Mammal implements Attackable {
  protected String species;
  protected int health;

  public Mammal(String species, int health) {
    this.species = species;
    this.health = health;
  }

  public String getSpecies() {
    return this.species;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public void takeDamage(int damageAmount) {
    this.health -= damageAmount;
  }

  public void attack(Attackable target) {
    // Decrement Health
    int targetHealth = target.getHealth();
    target.takeDamage(5);
  }
}