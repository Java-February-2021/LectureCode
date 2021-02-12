import java.util.Arrays;

public class PizzaTester {
  public static void main(String[] args) {
    String[] cheeseToppings = { "marinara sauce", "cheese" };
    Pizza cheesePizza = new Pizza("Cheese Pizza", 10, "XL", cheeseToppings);
    System.out.println(cheesePizza.getName());
    cheesePizza.setName("Extra Large Cheese Pizza");
    System.out.println(cheesePizza.getName());
    cheesePizza.setName("");
    System.out.println(cheesePizza.getName());
    Pizza.advertise();
    Pizza hawaiian = new Pizza("Hawaiian Pizza", 6, "L",
        new String[] { "marinara sauce", "cheese", "pineapple", "ham" });
    System.out.println(Pizza.numOfPizzas);
    System.out.println(hawaiian.getSlices());
    hawaiian.eatSlice(3);
    System.out.println(hawaiian.getSlices());
    hawaiian.displayPizza();
    Pizza meatLovers = new Pizza("Meat Lovers Pizza",
        new String[] { "marinara sauce", "cheese", "pepperoni", "chicken", "chorizo", "venison", "alligator" });
    System.out.println(meatLovers.getSize());
    meatLovers.eatSlice();
    hawaiian.pizzaFight(meatLovers);

  }

}