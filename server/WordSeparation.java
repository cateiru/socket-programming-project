import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import net.reduls.igo.Tagger;

/**
 * Divide by morphological analysis.
 *
 * @author Yuto Watanabe
 */
public class WordSeparation {
  private Tagger tagger = null;

  public WordSeparation() {
    try {
      this.tagger = new Tagger("ipadic");
    } catch (FileNotFoundException error) {
      error.printStackTrace();
    } catch (IOException error) {
      error.printStackTrace();
    }
  }

  /**
   * Divide by morphological analysis.
   *
   * @param text A sentence to be divided.
   * @return A word-separated list.
   */
  public List<String> analysis(String text) {
    return this.tagger.wakati(text);
  }
}
