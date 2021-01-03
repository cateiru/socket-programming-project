import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
   * @return array of MarkovElement.
   */
  public List<MarkovElement> read() {
    List<MarkovElement> text = new ArrayList<MarkovElement>(10);
    try {
      BufferedReader buffer = new BufferedReader(new FileReader(this.file));

      String value1 = "";
      String value2 = "";
      String value3 = "";
      boolean isStart = false;
      boolean isEnd = false;

      String line = "";
      while ((line = buffer.readLine()) != null) {
        String[] lineData = line.split(",", -1);

        if (lineData.length < 5) {
          throw new Error("CSV data is wrong.");
        }

        value1 = lineData[0];
        value2 = lineData[1];
        value3 = lineData[2];
        isStart = Boolean.valueOf(lineData[3]);
        isEnd = Boolean.valueOf(lineData[4]);

        text.add(new MarkovElement(value1, value2, value3, isStart, isEnd));
      }

      buffer.close();
    } catch (FileNotFoundException error) {
      error.printStackTrace();
    } catch (IOException error) {
      error.printStackTrace();
    }

    return text;
  }

  /**
   * Write to csv.
   *
   * @param text class of MarkovElement to write to CSV
   */
  public void write(MarkovElement[] text) {
    try {
      BufferedWriter buffer = new BufferedWriter(new FileWriter(this.file, true));

      for (int i = 0; text.length > i; ++i) {
        buffer.write(text[i].getCSV());
        buffer.newLine();
      }
      buffer.close();
    } catch (IOException error) {
      error.printStackTrace();
    }
  }
}
