import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random random = new Random(System.currentTimeMillis());

    ArrayList<String> words = new ArrayList<>();
    words.add(0, "HelloWorld");
    words.add(1, "Java");
    words.add(2, "Elephant");
    words.add(3, "Heaven");

    ArrayList<String> hints = new ArrayList<>();
    hints.add(0, "First word of a programmer.");
    hints.add(1, "Programming language that this program in used to write.");
    hints.add(2, "Largest land mammal.");
    hints.add(3, "Final destiny");

    int rand = random.nextInt(3);

    //
    System.out.println("Welcome to hangman game!!!");

    System.out.println("Your word is: " + hints.get(rand));
    char usrInput = scan.next().charAt(0);

    System.out.println(usrInput);

    scan.close();

  }
}
