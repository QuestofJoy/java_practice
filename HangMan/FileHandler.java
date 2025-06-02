import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

public class FileHandler {

  // configurable file path for OS compatibality
  public static final String CURRENT_PATH = Paths.get("").toAbsolutePath().toString();
  public static final String DIR_NAME = "data";
  public static final String PLAYERS_DIR_NAME = "data";

  public static final String DIR_PATH = CURRENT_PATH + File.separator + DIR_NAME;
  public static final String WORD_LIST_PATH = DIR_PATH + File.separator + "words.txt";
  public static final String HINT_LIST_PATH = DIR_PATH + File.separator + "hints.txt";
  public static final String PLAYERS_FOLER = DIR_PATH + File.separator + PLAYERS_DIR_NAME;

  public void makeMainFolder() {
    File dir = new File(DIR_PATH);
    boolean created = dir.mkdir();
    if (created) {
      System.out.println("Folder created");
    } else if (dir.exists()) {
      System.out.println("Folder exists");
    } else {
      System.out.println("error: Folder could not be created.");
    }
  }

  public void makePlayerProfileFolder() {
    File dir = new File(PLAYERS_DIR_NAME);
    boolean created = dir.mkdir();
    if (created) {
      System.out.println("Folder created");
    } else if (dir.exists()) {
      System.out.println("Folder exists");
    } else {
      System.out.println("error: Folder could not be created.");
    }
  }

  public void makeWordList() {
    try {
      File wordList = new File(WORD_LIST_PATH);
      if (wordList.createNewFile()) {
        System.out.println("Word-list created");
      } else {
        System.out.println("Word-list already exists! Skipping making Word-list....");
      }
    } catch (IOException e) {
      System.out.println("error: " + e.getMessage());
    }
  }

  public void makeHintList() {
    try {
      File hintList = new File(HINT_LIST_PATH);
      if (hintList.createNewFile()) {
        System.out.println("Hint-list created");
      } else {
        System.out.println("Hint-list already exists! Skipping making Hint-list....");
      }
    } catch (IOException e) {
      System.out.println("error: " + e.getMessage());
    }
  }
  // public void words() {
  // try {
  //
  // }
  // }

}
