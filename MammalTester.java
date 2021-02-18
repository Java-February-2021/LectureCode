import java.util.ArrayList;

public class MammalTester {
  public static void main(String[] args) {
    Mammal dolphin = new Mammal("dolphin", 100);
    Gorilla gorilla = new Gorilla();

    gorilla.eatBanana();
    System.out.println(gorilla.getHealth());
    Barrel b1 = new Barrel("bonus barrel", 10);
    gorilla.attack(b1);

    Giraffe jeffrey = new Giraffe();
  }
}