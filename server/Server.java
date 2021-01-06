import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {

  public static void main(String[] args) {

    Scanner stdIn = new Scanner(System.in);
    int port = inputPort(stdIn);
    stdIn.close();

    Connect connectOperation = new Connect(port);
    MarkovChain chain = new MarkovChain();

    Pattern pattern = Pattern.compile("/(?<command>(train|end|reset|generate))(\s(?<text>.*))?");

    while (true) {
      String text = connectOperation.getText();

      try {
        Matcher matcher = pattern.matcher(text);

        matcher.find();

        if (matcher.group("command").equals("end")) {
          // End server.
          connectOperation.postText("Close server...");
          break;

        } else if (matcher.group("command").equals("train")) {
          // Add new training data.
          String useText = matcher.group("text");
          if (useText == null) {
            connectOperation.postText("Requires arguments. Example: /train 本日は晴天なり");
          } else {
            System.out.println(String.format("Train text: %s", useText));
            chain.addElement(useText);
            connectOperation.postText("Succeeded.");
          }

        } else if (matcher.group("command").equals("generate")) {
          // Run Markov algorithm.
          connectOperation.postText(chain.generate());

        } else if (matcher.group("command").equals("reset")) {
          // reset data.
          chain.reset();
          connectOperation.postText("Succeeded.");
        }
      } catch (IllegalStateException error) {
        connectOperation.postText("This command is not found.");
      }
    }

    connectOperation.close();
  }

  /**
   * Input port number from console.
   *
   * @param stdIn instance of Scanner class.
   * @return port number.
   */
  static int inputPort(Scanner stdIn) {
    int port = 0;

    try {
      System.out.print("* Please input port number: ");
      port = stdIn.nextInt();
    } catch (InputMismatchException error) {
      System.out.println("The input is mismatched. Type it again.");
      port = inputPort(stdIn);
    } catch (NoSuchElementException error) {
      error.printStackTrace();
    } catch (IllegalStateException error) {
      error.printStackTrace();
    }

    return port;
  }
}
