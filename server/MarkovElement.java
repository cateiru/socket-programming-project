/**
 * Markov element.
 *
 * @author Yuto Watanabe
 */
public class MarkovElement {
  private String value1;
  private String value2;
  private String value3;
  private boolean isStart;
  private boolean isEnd;

  public MarkovElement(
      String value1, String value2, String value3, boolean isStart, boolean isEnd) {
    this.value1 = value1;
    this.value2 = value2;
    this.value3 = value3;
    this.isStart = isStart;
    this.isEnd = isEnd;
  }

  /**
   * generate csv format data.
   *
   * @return csv format string data.
   */
  public String getCSV() {
    return String.format(
        "%s,%s,%s,%b,%b", this.value1, this.value2, this.value3, this.isStart, this.isEnd);
  }

  /**
   * Check if the values are the same.
   *
   * @param value1 value 1
   * @param value2 value 2
   * @param value3 value 3
   */
  public boolean checkDuplicate(String value1, String value2, String value3) {
    return value1.equals(this.value1) && value2.equals(this.value2) && value3.equals(this.value3);
  }

  /**
   * Check if the value1.
   *
   * @param value1 value 1
   */
  public boolean checkValue1(String value1) {
    return value1.equals(this.value1);
  }

  /** Get connected sentences. */
  public String getString() {
    if (this.isEnd) {
      return String.format("%s%s%s", this.value1, this.value2, this.value3);
    }
    return String.format("%s%s", this.value1, this.value2);
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
   * Get value2.
   *
   * @return string of value2.
   */
  public String getValue3() {
    return this.value3;
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
}
