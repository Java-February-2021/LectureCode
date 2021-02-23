import java.util.Arrays;

public class Example {
  public static void main(String[] args) {
    String tags = "coffee, tea, drink";
    String[] tagSplit = tags.split(", ");

    System.out.println(Arrays.toString(tagSplit));
    for (String s : tagSplit) {
      System.out.println(s);
    }

  }
}