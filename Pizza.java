public class Pizza {
  // Things or Attributes that Pizza's have
  // Type Of Pizza - Hawaiian, Meat Lovers, Pineapple
  // How many Slices are the pizza
  // Size
  // Toppings - All toppings on the pizza
  private String name;
  private int slices;
  private String size;
  private String[] toppings;
  static int numOfPizzas;

  // Constructor
  public Pizza(String name, int slices, String size, String[] toppings) {
    this.name = name;
    this.slices = slices;
    this.size = size;
    this.toppings = toppings;
    numOfPizzas++;
  }

  // Overloaded Constructor
  public Pizza(String name, String[] toppings) {
    this.name = name;
    this.size = "Extra Extra Large";
    this.slices = 18;
    this.toppings = toppings;
    numOfPizzas++;
  }

  // Getter Methods
  public String getName() {
    return this.name;
  }

  public int getSlices() {
    return this.slices;
  }

  public String getSize() {
    return this.size;
  }

  public String[] getToppings() {
    return this.toppings;
  }

  // Setter
  public void setName(String name) {
    if (name.equals("")) {
      System.out.println("Hey, pizza's need a valid name!");
      return;
    }
    this.name = name;
  }

  public void setSlices(int slices) {
    this.slices = slices;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setToppings(String[] toppings) {
    this.toppings = toppings;
  }

  // Things we can do
  // eat()
  // display()
  // advertise() --Static--
  // STATIC
  public static void advertise() {
    System.out.println("Come eat at the best pizza place in town! Not mafia owned (that we can admit)");
  }

  public int eatSlice(int slices) {
    System.out.println("You have eaten a slice of " + this.name + " Pizza");
    this.slices -= slices;
    return this.slices;
  }

  // Overloaded Method
  public int eatSlice() {
    this.slices -= 1;
    return this.slices;
  }

  public void displayPizza() {
    System.out.printf("This is a %s pizza with %d slices\n", this.name, this.slices);
  }

  // Interact with another object
  public void pizzaFight(Pizza otherPizza) {
    int otherSlices = otherPizza.getSlices();
    otherPizza.setSlices(otherSlices -= 1);
    System.out.println(this.name + " just knocked a slice off of " + otherPizza.getName());
    System.out.println(otherPizza.getSlices());
  }

}