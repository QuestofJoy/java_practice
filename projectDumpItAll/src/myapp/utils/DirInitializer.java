package myapp.utils;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class DirInitializer {
  private static final String DIR_CURRENT = Paths.get("").toAbsolutePath().toString();

  public static final String DIR_USER_DATA = DIR_CURRENT + File.separator + "userData";

  public static void UserDirInitializer() {
    File file = new File(DIR_USER_DATA);
    boolean created = false;
    if (file.exists()) {
      created = true;
      System.out.println("file created");
    }

    if (!created) {
      if (file.mkdir()) {
        System.out.println("user folder created");
      } else {
        System.out.println("user folder could not be created");
      }
    }

  }

  public static void makeUserProfile(String userName, String userPassword) {
    String userProfileFileName = userName + ".txt";

    File userProfile = new File(DIR_USER_DATA + File.separator + userProfileFileName);

    try {
      if (!userProfile.createNewFile()) {
        System.out.println("user exists!!");
      } else {
        System.out.println("user created");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("user could not be created");
    }

    try (FileWriter fw = new FileWriter(userProfile, true)) {
      fw.write("userName=");
      fw.write(userName + System.lineSeparator());
      fw.write("userPassword=");
      fw.write(userPassword + System.lineSeparator());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void loadUserProfile(String userName, String userPassword) {
    String userProfileFileName = userName + ".txt";
    File userProfile = new File(DIR_USER_DATA + File.separator + userProfileFileName);

    List<String> userInfo = new ArrayList<>();

    // checking if the user profile exists
    if (!userProfile.exists()) {
      System.out.println("user not found");
      return;
    }

    // pulling out username and password of the existing user
    try (BufferedReader bfr = new BufferedReader(new FileReader(userProfile))) {
      String line;
      while ((line = bfr.readLine()) != null) {
        line = line.substring(line.indexOf("=") + 1);
        userInfo.add(line);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    if (userName.matches(userInfo.get(0)) && userPassword.matches(userInfo.get(1))) {
      System.out.println("successfully loaded user profile");
    } else {
      System.out.println("invalid password");
    }

  }

  public static void userCredentialChecker(String userName, String userPassword) {

  }

  // public boolean searchUserProfile() {
  // boolean found = false;
  // }
  //
  // public boolean makeUserProfile() {
  // boolean created = false;
  // File newUserProfile = new File(DIR_USER_DATA + File.separator + "User");
  // return created;
  // }
  //
}
