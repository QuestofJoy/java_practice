import java.io.FileWriter;
import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class GameData {

  public static final List<String> WORDS = new ArrayList<>();
  public static final List<String> HINTS = new ArrayList<>();

  // This is where all the data for the game are loaded from.
  // dynamic adding or removing is what this code allows

  // dont forget to add both words and hints
  public void wordsLoad() {
    WORDS.add("Java");
    WORDS.add("Elephant");
    WORDS.add("Jhon Cena");
  }

  public void hintsLoad() {
    HINTS.add("Name of the programming language this game was written on.");
    HINTS.add("Largest land mammal.");
    HINTS.add("You can't see me.");
  }

  public void writeToFile(String path, List<String> contentList) {
    try (
        FileWriter fWrite = new FileWriter(path);
        BufferedWriter bfWrite = new BufferedWriter(fWrite);) {
      for (String line : contentList) {
        bfWrite.write(line);
        bfWrite.newLine();
      }
    } catch (IOException e) {
      System.out.println("error: " + e.getMessage());
    }

  }

  // public void readFromFile(String path) {
  // try (
  // FileReader fRead = new FileReader(path);
  // BufferedReader bfRead = new BufferedReader(fRead);) {
  // String line;
  // while ((line = bfRead.readLine()) != null) {
  // System.out.println(line);
  // }
  //
  // } catch (IOException e) {
  // System.out.println("error: " + e.getMessage());
  // }
  //
  // }
}
