public class GameInitialize {
  GameData gameData = new GameData();

  public GameInitialize() {
    gameData.wordsAdd();
    gameData.hintsAdd();
    FileHandler loader = new FileHandler();
    loader.makeFolder();
    loader.makeWordList();
    loader.makeHintList();
    gameData.writeToFile(FileHandler.wordListPath, GameData.words);
    gameData.writeToFile(FileHandler.hintListPath, GameData.hints);
    gameData.readFromFile(FileHandler.wordListPath);
    gameData.readFromFile(FileHandler.hintListPath);
  }

}
