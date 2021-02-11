import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
  public static void main(String[] args) {
    // Strings
    String name = "Andy";
    String name2 = "Andy";
    String name3 = "Andy";

    String firstName = new String("Andy");
    String firstName2 = new String("Andy");
    System.out.println(firstName.equals(firstName2));

    // Arrays
    String[] people;
    String[] classPeople = { "Shivi", "Matthew", "Jesus", "Damon", "Ben" };
    Object[] randomStuff = { "Shivi", 78, true };

    // ARRAYS ARE FIXED IN SIZE!!!!!
    classPeople[1] = "Cesar";

    int[] numbers = new int[10];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i + 1;
    }
    System.out.println(classPeople);
    System.out.println(Arrays.toString(classPeople));

    // ArrayLists / Collections
    ArrayList<String> stringList = new ArrayList<String>();
    stringList.add("zero");
    stringList.add("one");
    stringList.add("two");
    stringList.add("three");
    System.out.println(stringList);

    // ForEach Loop
    for (String number : stringList) {
      System.out.println(number);
    }

    // HashMaps
    HashMap<String, String> ourHobbies = new HashMap<String, String>();
    ourHobbies.put("Andy", "Golf and Snowboarding");
    ourHobbies.put("Shivi", "Football");
    ourHobbies.put("Sergio", "Soccer");
    ourHobbies.put("Cesar", "Formula 1");
    ourHobbies.put("Matthew", "Photography");
    ourHobbies.put("Zoe", "Cooking");
    ourHobbies.put("Jesus", "Weight lifting");
    ourHobbies.put("Ben", "Bike Riding");
    ourHobbies.put("Amanda", "WebFunner");

    for (HashMap.Entry<String, String> entry : ourHobbies.entrySet()) {
      System.out.println(entry);
    }

    // Methods
    System.out.println(maxArrayValue(numbers));

    System.out.println("We made it after the method call! Wooohoo!!");
  }

  public static int maxArrayValue(int[] nums) {
    // Variable that holds the max number
    // Loop through the array and if the number looping is greater than max
    // variable, replace it
    // return that max number
    int maxNumber = nums[0];
    for (int i = 0; i <= nums.length; i++) {
      try {
        if (nums[i] > maxNumber) {
          maxNumber = nums[i];
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    return maxNumber;
  }
}