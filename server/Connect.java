import java.io.*;
import java.net.*;

/**
 * Socket communication
 *
 * @author Yuto Watanabe
 */
public class Connect {
  private Socket socket = null;
  private int port;
  private BufferedReader in = null;
  private PrintWriter out = null;

  public Connect(int port) {
    this.port = port;
    this.createSocket();

    this.in = inObj();
    this.out = outObj();
  }

  private void createSocket() {
    try {
      ServerSocket serverSocket = new ServerSocket(this.port);
      this.socket = serverSocket.accept();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private BufferedReader inObj() {
    InputStreamReader streamReader = null;

    try {
      streamReader = new InputStreamReader(this.socket.getInputStream());
    } catch (IOException error) {
      error.printStackTrace();
    }
    return new BufferedReader(streamReader);
  }

  private PrintWriter outObj() {
    PrintWriter printWriter = null;

    try {
      printWriter = new PrintWriter(this.socket.getOutputStream(), true);
    } catch (IOException error) {
      error.printStackTrace();
    }
    return printWriter;
  }

  public void postText(String text) {
    this.out.println(text);
  }

  public String getText() {
    String text = null;

    try {
      text = this.in.readLine();
    } catch (IOException error) {
      error.printStackTrace();
    }
    return text;
  }

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
