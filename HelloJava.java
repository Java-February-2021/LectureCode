public class HelloJava {
  // Entry Point Method
  public static void main(String[] args) {
    // Variables
    byte myByte = 100; // store whole numbers from -128 127
    short myShort = 1000; // stores whole numbers from -32768 to 32767
    int myInt = 100000; // stores whole numbers from -2,147,483,648 -2,147,483,647
    long myLong = 300000000; // stores whole numbers -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
    float myFloat = 3.14f; // stores fractional numbers from 6 to 7 decimal digits
    double myDouble = 3.1474754; // stores fractional numbers up to 15 decimal digits..

    boolean myBool = true; // stores true or false values
    char myChar = 'a';

    Character myCharacter = 'd';
    System.out.println(Character.toUpperCase(myCharacter));

    // Strings
    String myString = "Java February 2021";
    System.out.println(myString.length());

    String bootcamp = "Java";
    String bootCamp = "February";
    String bootCAMP = "2021";

    System.out.println(bootcamp + bootCamp + bootCAMP);

    // Operators and Conditionals
    String myName = "Matt";
    String myName2 = "Matt";

    int isOdd = 5;
    if (isOdd % 2 != 0) {
      System.out.println("Number is odd");
    } else {
      System.out.println("Number is not odd");
    }

    // Loops
    int i = 0;
    while (i < 4) {
      System.out.println(i);
      i++;
    }

    for (int j = 0; j < 4; j++) {
      System.out.println(j);
    }

    // Methods
    System.out.println(sayHello("Shivi"));
    sayHello();
  }

  public static String sayHello(String name) {
    return "Hello! " + name;
  }

  public static void sayHello() {
    System.out.println("Hello!");
  }
}