import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarkovChain {
  private WordSeparation analysis;
  private List<MarkovElement> element;
  private List<String> alreadyExists;
  private Random random;

  public MarkovChain() {
    this.analysis = new WordSeparation();
    this.element = new ArrayList<MarkovElement>(1);
    this.alreadyExists = new ArrayList<String>(1);
    this.random = new Random();
  }

  /**
   * Add sentences to increase the models used for Markov chains. Divide by clause.
   *
   * @param text The text to use.
   */
  public void addElement(String text) {
    if (this.alreadyExists.indexOf(text) != -1) {
      return;
    }
    this.alreadyExists.add(text);

    List<String> formattedText = analysis.analysis(text);

    int start = 0;
    boolean isPhrase = false;

    for (int i = 0; formattedText.size() > i; ++i) {
      if ("。".equals(formattedText.get(i))) {
        this.add(formattedText.subList(start, i + 1));
        start = i + 1;
        isPhrase = true;
      }
    }

    if (!isPhrase) {
      this.add(formattedText);
    }
  }

  /**
   * Add sentences to increase the models used for Markov chains.
   *
   * @param formattedText A word-separated sentence.
   */
  private void add(List<String> formattedText) {
    int splitLength = formattedText.size();

    for (int i = 0; (splitLength - 1) > i; ++i) {
      String value1 = formattedText.get(i);
      String value2 = formattedText.get(i + 1);
      String value3 = "";
      if (i + 3 < splitLength) {
        value3 = formattedText.get(i + 2);
      }
      boolean isStart = false;
      boolean isEnd = false;

      if (i == 0) {
        isStart = true;
      }
      if (i == (splitLength - 2)) {
        isEnd = true;
      }
      this.element.add(new MarkovElement(value1, value2, value3, isStart, isEnd));
    }
  }

  /**
   * The text to use.
   *
   * @return generated text.
   */
  public String generate() {
    List<MarkovElement> startElement = new ArrayList<MarkovElement>(1);

    for (int i = 0; this.element.size() > i; ++i) {
      MarkovElement getElement = this.element.get(i);
      if (getElement.getIsStart()) {
        startElement.add(getElement);
      }
    }

    String text = this.recursionSentenceGeneration(startElement);

    return text;
  }

  /** Reset of train data. */
  public void reset() {
    this.element = new ArrayList<MarkovElement>(1);
    this.alreadyExists = new ArrayList<String>(1);
  }

  /**
   * Generate sentences using recursion.
   *
   * @param useTexts Usable objects.
   */
  private String recursionSentenceGeneration(List<MarkovElement> useTexts) {
    if (useTexts.size() == 0) {
      return "";
    }
    int useIndex = random.nextInt(useTexts.size());
    MarkovElement useText = useTexts.get(useIndex);
    List<MarkovElement> nextElement = new ArrayList<MarkovElement>(1);

    StringBuilder textBuffer = new StringBuilder();
    textBuffer.append(useText.getString());

    if (!useText.getIsEnd()) {
      String nextText = useText.getValue3();
      if (nextText == "") {
        nextText = useText.getValue2();
      }
      for (int i = 0; this.element.size() > i; ++i) {
        MarkovElement selectElement = this.element.get(i);
        if (selectElement.checkValue1(nextText)) {
          nextElement.add(selectElement);
        }
      }
      textBuffer.append(this.recursionSentenceGeneration(nextElement));
    }

    return textBuffer.toString();
  }

  /** Export trained data. */
  public void printData() {
    for (int i = 0; this.element.size() > i; ++i) {
      MarkovElement element = this.element.get(i);
      System.out.println(element.getCSV());
    }
  }
}
