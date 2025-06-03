public class InitializeData {

  public InitializeData() {
    initializeGameData();
    setupFileSystem();
    writeInitialData();
  }

  private void initializeGameData() {
    // initialize words and hints data
    GameData gameData = new GameData();

    gameData.wordsLoad();
    gameData.hintsLoad();
  }

  private void setupFileSystem() {
    // create a folder(skips if there is already one from FileFolderManager)
    // these might be unnecessary stuffs for hangman game but hey
    // WE ARE HERE TO LEARN
    FileFolderManager ffm = new FileFolderManager();

    ffm.makeFolder(FileFolderManager.CURRENT_PATH, FileFolderManager.ROOT_DIR_NAME);

    ffm.makeFile(FileFolderManager.ROOT_DIR_PATH, FileFolderManager.PLAYER_DATA_FILE_NAME);
    ffm.makeFile(FileFolderManager.ROOT_DIR_PATH, FileFolderManager.WORDS_FILE_NAME);
    ffm.makeFile(FileFolderManager.ROOT_DIR_PATH, FileFolderManager.HINTS_FILE_NAME);
  }

  public void writeInitialData() {
    FileFolderManager ffm = new FileFolderManager();
    // writes to File as the variable explains.
    // the method write and read will always run which is not necessary
    // unless the data is changed
    // that work is for the future me
    // the current program does not check if
    // list of hints and word is equal
    ffm.writeToFile(FileFolderManager.WORDS_FILE_PATH, GameData.getWords());
    ffm.writeToFile(FileFolderManager.PLAYER_DATA_FILE_PATH, GameData.getHints());
  }

}
