import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Read and write csv file.
 *
 * @author Yuto Watanabe
 */
public class CSVOperation {
  private String filePath;
  private File file = null;

  public CSVOperation(String filePath) {
    this.filePath = filePath;
    this.file = new File(this.filePath);
  }

  /**
   * Read CSV file.
   *
   * @return csv.
   */
  public List<String> read() {
    BufferedReader buffer = new BufferedReader(new FileReader(this.file));

    List<String> text = new ArrayList<String>(10);

    String line = "";
    while ((line = buffer.readLine()) != null) {
      // StringTokenizer lineData = new StringTokenizer(line, ",");

      // while (lineData.hasMoreTokens()) {}

      text.add(line);
    }

    buffer.close();

    return text;
  }

  /**
   * Write to csv.
   *
   * @param text Text to write to CSV
   */
  public void write(String[] text) {
    BufferedWriter buffer = new BufferedWriter(new FileWriter(this.file, true));

    for (int i = 0; text.length > i; ++i) {
      buffer.write(text[i]);
      buffer.newLine();
    }
    buffer.close();
  }
}
