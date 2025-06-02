public class InitializeDataAndFolder {
  GameData gameData = new GameData();

  public InitializeDataAndFolder() {
    // initialize words and hints data
    gameData.wordsLoad();
    gameData.hintsLoad();

    // create a folder(skips if there is already one)
    // these might be unnecessary stuffs for hangman game but hey
    // WE ARE HERE TO LEARN
    FileHandler loader = new FileHandler();
    loader.makeMainFolder();
    loader.makePlayerProfileFolder();
    // loader.makeWordList();
    // loader.makeHintList();

    // writes to File as the variable explains.
    // the method write and read will always run which is not necessary
    // unless the data is changed
    // that work is for the future me
    // the current program does not check if
    // list of hints and word is equal

    gameData.writeToFile(FileHandler.WORD_LIST_PATH, GameData.WORDS);
    gameData.writeToFile(FileHandler.HINT_LIST_PATH, GameData.HINTS);
    // gameData.readFromFile(FileHandler.wordListPath);
    // gameData.readFromFile(FileHandler.hintListPath);
  }

}
