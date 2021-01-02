/**
 * Markov element.
 *
 * @author Yuto Watanabe
 */
public class MarkovElement {
  private String value1;
  private String value2;
  private boolean isStart;
  private boolean isEnd;
  private int count;

  public MarkovElement(String value1, String value2, boolean isStart, boolean isEnd, int count) {
    this.value1 = value1;
    this.value2 = value2;
    this.isStart = isStart;
    this.isEnd = isEnd;
    this.count = count;
  }

  /**
   * generate csv format data.
   *
   * @return csv format string data.
   */
  public String getCSV() {
    return String.format("%s,%s,%b,%b,%d", this, value1, this.value2, this.isStart, this.isEnd);
  }

  /**
   * Check if the values are the same.
   *
   * @param value1 value 1
   * @param value2 value 2
   */
  public boolean checkDuplicate(String value1, String value2) {
    return value1.equals(this.value1) && value2.equals(this.value2);
  }

  /** Add count. */
  public void addCount() {
    this.count++;
  }

  /**
   * Get value1.
   *
   * @return string of value1.
   */
  public String getValue1() {
    return this.value1;
  }

  /**
   * Get value2.
   *
   * @return string of value2.
   */
  public String getValue2() {
    return this.value2;
  }

  /**
   * Get isStart.
   *
   * @return boolean of isStart. true is start element, false is not.
   */
  public boolean getIsStart() {
    return this.isStart;
  }

  /**
   * Get isEnd.
   *
   * @return boolean of isEnd. true is end element, false is not.
   */
  public boolean getIsEnd() {
    return this.isEnd;
  }

  /**
   * Get count.
   *
   * @return Number of appearances.
   */
  public int getCount() {
    return this.count;
  }
}
