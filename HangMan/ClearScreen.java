public class ClearScreen {
  public static void clearScreen(int seconds) {
    try {
      Thread.sleep(seconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void clearScreen() {
    clearScreen(0);
  }
}
