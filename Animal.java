public class Animal {
  private String name;
  private int strength;
  private int health;
  private String diet;
  private int speed;

  // Constructor
  public Animal(String name, int strength, String diet, int speed) {
    this.name = name;
    this.strength = strength;
    this.health = 100;
    this.diet = diet;
    this.speed = speed;
  }

  public Animal(String name, int strength, int speed) {
    this.name = name;
    this.strength = strength;
    this.health = 100;
    this.diet = "Herbovior";
    this.speed = speed;
  }

  // Getters
  public String getName() {
    return this.name;
  }

  public int getStrength() {
    return this.strength;
  }

  public int getHealth() {
    return this.health;
  }

  public String getDiet() {
    return this.diet;
  }

  public int getSpeed() {
    return this.speed;
  }

  // Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setDiet(String diet) {
    this.diet = diet;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  // Class Methods

  // Attacks another Animal
  public void battle(Animal target, String powerMove) {
    // Define the logic of how an animal attakcs
    int damage;
    // Declare PowerMoves
    if (powerMove.equals("fireball")) {
      damage = 3;
    } else if (powerMove.equals("roar")) {
      damage = 4;
    } else if (powerMove.equals("kick")) {
      damage = 4;
    } else if (powerMove.equals("windblower")) {
      damage = 5;
    } else {
      System.out.println("Move not recognized");
      return;
    }

    // multiply damage x strength
    int effectiveDamage = this.strength * damage;

    // reduce the target animal's health by the effectiveDamage
    int otherObjectHealth = target.getHealth();
    target.setHealth(otherObjectHealth -= effectiveDamage);

    // Print to the console what just happened using a formatted string
    System.out.printf("%s attacks %s for %d\n", this.name, target.getName(), effectiveDamage);
    System.out.println(target.getName() + " now has " + target.getHealth() + " health.");
  }

  // Overloaded Method
  public void battle(Animal target) {
    battle(target, "fireball");
  }

}