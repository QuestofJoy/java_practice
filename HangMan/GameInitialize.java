public class GameInitialize {
  GameData gameData = new GameData();

  public GameInitialize() {
    // initialize words and hints data
    gameData.wordsLoad();
    gameData.hintsLoad();

    // create a folder(skips if there is already one)
    // these might be unnecessary stuffs for hangman game but hey
    // WE ARE HERE TO LEARN
    FileFolderManager loader = new FileFolderManager();
    loader.makeFolder(FileFolderManager.CURRENT_PATH, FileFolderManager.DIR_NAME);
    loader.makeFile(FileFolderManager.DIR_PATH, FileFolderManager.WORDS_FILE_NAME);
    loader.makeFile(FileFolderManager.DIR_PATH, FileFolderManager.HINTS_FILE_NAME);

    // writes to File as the variable explains.
    // the method write and read will always run which is not necessary
    // unless the data is changed
    // that work is for the future me
    // the current program does not check if
    // list of hints and word is equal
    loader.writeToFile(FileFolderManager.WORDS_FILE_PATH, GameData.WORDS);
    loader.writeToFile(FileFolderManager.HINTS_FILE_PATH, GameData.HINTS);

  }

}
