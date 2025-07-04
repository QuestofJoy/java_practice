import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.BufferedReader;
// import java.io.IOException;
import java.util.List;

public class FileFolderManager {

  // configurable file path for OS compatibality
  public static final String CURRENT_PATH = Paths.get("").toAbsolutePath().toString();
  public static final String ROOT_DIR_NAME = "data";
  public static final String PLAYER_DATA_FILE_NAME = "playerInfo.txt";

  public static final String ROOT_DIR_PATH = CURRENT_PATH + File.separator + ROOT_DIR_NAME;

  public static final String PLAYER_DATA_FILE_PATH = ROOT_DIR_PATH + File.separator + PLAYER_DATA_FILE_NAME;

  public void makeFolder(String dirPath, String dirName) {
    File dir = new File(dirPath + File.separator + dirName);
    boolean created = dir.mkdir();
    if (created) {
      System.out.println("Folder " + dirName + " created");
    } else if (dir.exists()) {
      System.out.println("Folder " + dirName + " exists");
    } else {
      System.out.println("error: Folder " + dirName + " could not be created.");
    }
  }

  public void makeFile(String filePath, String fileName) {
    try {
      File wordList = new File(filePath + File.separator + fileName);
      if (wordList.createNewFile()) {
        System.out.println(fileName + " created");
      } else {
        System.out.println(fileName + " already exists! Skipping making" + fileName + "....");
      }
    } catch (IOException e) {
      System.out.println("error: " + e.getMessage());
    }
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
  // public void words() {
  // try {
  //
  // }
  // }

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
