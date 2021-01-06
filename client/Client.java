import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
    int port = inputPort(stdIn);
    String address = inputAddress(stdIn);

    Connect connectOperation = new Connect(port, address);
    String text;

    try {
      while (true) {
        System.out.print("> ");
        text = keyIn.readLine();
        connectOperation.postText(text);

        String responseText = connectOperation.getText();
        System.out.println(responseText);

        if (text.equals("/end")) {
          break;
        }
      }
    } catch (IOException error) {
      error.printStackTrace();
    }

    connectOperation.close();
    stdIn.close();
  }

  /**
   * Input port number from console.
   *
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

  static String inputAddress(Scanner stdIn) {
    String address = "127.0.0.1";

    try {
      System.out.print("* Please input address: ");
      address = stdIn.next();
    } catch (InputMismatchException error) {
      System.out.println("The input is mismatched. Type it again.");
      address = inputAddress(stdIn);
    } catch (NoSuchElementException error) {
      error.printStackTrace();
    } catch (IllegalStateException error) {
      error.printStackTrace();
    }
    return address;
  }
}
