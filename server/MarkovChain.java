public class MarkovChain {
  private String filePath;
  private CSVOperation csv;
  private WordSeparation analysis;

  public MarkovChain(String filePath) {
    this.filePath = filePath;
    this.csv = new CSVOperation(this.filePath);
    this.analysis = new WordSeparation();
  }
}
