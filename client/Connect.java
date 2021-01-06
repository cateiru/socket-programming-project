import java.io.*;
import java.net.*;

/**
 * Socket communication of client.
 *
 * @author Yuto Watanabe
 */
public class Connect {
  private Socket socket = null;
  private int port;
  private BufferedReader in = null;
  private PrintWriter out = null;
  private String address;

  /**
   * constructor to establish a connection.
   *
   * @param port Port number.
   */
  public Connect(int port, String address) {
    this.port = port;
    this.address = address;
    this.createSocket();

    this.in = inObj();
    this.out = outObj();
  }

  /** Create socket. */
  private void createSocket() {
    try {
      this.socket = new Socket(address, this.port);
      System.out.printf("Connect to %s\n", this.socket.getRemoteSocketAddress());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Create buffer reader object.
   *
   * @return BufferedReader object.
   */
  private BufferedReader inObj() {
    InputStreamReader streamReader = null;

    try {
      streamReader = new InputStreamReader(this.socket.getInputStream());
    } catch (IOException error) {
      error.printStackTrace();
    }
    return new BufferedReader(streamReader);
  }

  /**
   * Print writer object.
   *
   * @return PrintWriter object.
   */
  private PrintWriter outObj() {
    PrintWriter printWriter = null;

    try {
      printWriter = new PrintWriter(this.socket.getOutputStream(), true);
    } catch (IOException error) {
      error.printStackTrace();
    }
    return printWriter;
  }

  /**
   * Post text.
   *
   * @param text The string to send.
   */
  public void postText(String text) {
    this.out.println(text);
  }

  /**
   * Get the text.
   *
   * @return Obtained character string.
   */
  public String getText() {
    String text = "";

    try {
      text = this.in.readLine();
    } catch (IOException error) {
      error.printStackTrace();
    }
    return text;
  }

  /** Close socket and more. */
  public void close() {
    try {
      this.in.close();
      this.out.close();
      this.socket.close();
    } catch (IOException error) {
      this.close();
    }
  }
}
