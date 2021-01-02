import java.util.ArrayList;
import java.util.List;

public class MarkovChain {
  private WordSeparation analysis;
  private List<MarkovElement> element;

  public MarkovChain() {
    this.analysis = new WordSeparation();
    this.element = new ArrayList<MarkovElement>(10);
  }

  public void addElement(String text) {
    List<String> formattedText = analysis.analysis(text);
    int splitLength = formattedText.size();

    for (int i = 0; (splitLength - 1) > i; ++i) {
      String value1 = formattedText.get(i);
      String value2 = formattedText.get(i + 1);
      boolean isStart = false;
      boolean isEnd = false;

      if (i == 0) {
        isStart = true;
      }
      if (i == (splitLength - 2)) {
        isEnd = true;
      }

      // If the same element already exists, `count` is incremented.
      int index = check(value1, value2);
      if (index == -1) {
        this.element.add(new MarkovElement(value1, value2, isStart, isEnd, 0));
      } else {
        MarkovElement addCountElement = this.element.get(index);
        addCountElement.addCount();
      }
    }
  }

  private int check(String value1, String value2) {
    for (int i = 0; this.element.size() > i; ++i) {
      MarkovElement element = this.element.get(i);
      if (element.checkDuplicate(value1, value2)) {
        return i;
      }
    }
    return -1;
  }

  public String generate() {
    return "";
  }
}
