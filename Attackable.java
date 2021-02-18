public interface Attackable {
  // To be attacked you must have health
  // All you can put in are method signatures.
  int getHealth();

  void setHealth(int health);

  void takeDamage(int damageAmount);
}