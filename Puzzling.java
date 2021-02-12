import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Puzzling {
  public static void main(String[] args) {
    RandoS105();

  }

  // Generate an array with 10 random strings that are each 5 characters long
  public static void RandoS105() {
    // generate strings
    Random randomMethod = new Random();
    ArrayList<Character> randomListofLetters = new ArrayList<Character>();
    ArrayList<String> Arrayof10 = new ArrayList<String>();
    char[] FiveCharacterArray = new char[5];
    String str2 = new String();
    // generate arrays
    // 10 string array ready to be filled
    for (int j = 0; j <= 10; j++) {
      System.out.println(str2);

      // generate random alphabet
      for (char ch = 'A'; ch <= 'Z'; ++ch) {
        randomListofLetters.add(ch);
        Collections.shuffle(randomListofLetters);
      }
      // 5 character strings
      for (int i = 0; i < 5; i++) {
        int randomNumber = randomMethod.nextInt(26);
        FiveCharacterArray[i] = (randomListofLetters.get(randomNumber));
        str2 = String.valueOf(FiveCharacterArray);
      }
      Arrayof10.add(str2);
    }
    System.out.println(Arrayof10);
  }
}