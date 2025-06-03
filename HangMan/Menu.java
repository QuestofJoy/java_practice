import java.util.Scanner;

public class Menu {
  public int menuList() {
    int usrInput = 0;
    System.out.println("1. Start game");
    System.out.println("2. Exit game");
    Scanner scan = new Scanner(System.in);
    scan.nextInt(usrInput);
    scan.nextLine();
    scan.close();
    return usrInput;
  }

  public void head() {
    System.out.println("----------------------------");
    System.out.println("        Hangman game");
    System.out.println("----------------------------");
  }

}
