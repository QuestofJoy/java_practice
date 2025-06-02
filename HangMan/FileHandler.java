import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

public class FileHandler {
  public static final String currentPath = Paths.get("").toAbsolutePath().toString();
  public static final String dirName = "data";
  public static final String dirPath = currentPath + "/" + dirName;
  public static final String wordListPath = dirPath + "/words.txt";
  public static final String hintListPath = dirPath + "/hints.txt";

  public void makeFolder() {
    File dir = new File(dirPath);
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
      File wordList = new File(wordListPath);
      if (wordList.createNewFile()) {
        System.out.println("Word-list created");
      } else {
        System.out.println("Word-list already exists. Skipping making Word-list");
      }
    } catch (IOException e) {
      System.out.println("error: " + e.getMessage());
    }
  }

  public void makeHintList() {
    try {
      File hintList = new File(hintListPath);
      if (hintList.createNewFile()) {
        System.out.println("Hint-list created");
      } else {
        System.out.println("Hint-list already exists. Skipping making Hint-list");
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
