import java.util.List;
import java.util.ArrayList;

public class GameData {

  private static final List<String> WORDS = new ArrayList<>();
  private static final List<String> HINTS = new ArrayList<>();

  // This is where all the data for the game are loaded from.
  // dynamic adding or removing is what this code allows

  // dont forget to add both words and hints
  public void wordsLoad() {
    WORDS.add("Java");
    WORDS.add("Elephant");
    WORDS.add("JhonCena");
  }

  public void hintsLoad() {
    HINTS.add("Name of the programming language this game was written on.");
    HINTS.add("Largest land mammal.");
    HINTS.add("You can't see me.");
  }

  public static List<String> getWords() {
    return new ArrayList<>(WORDS);
  }

  public static List<String> getHints() {
    return new ArrayList<>(HINTS);
  }

}
