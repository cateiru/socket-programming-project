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

  private createSocket() {
    try {
      ServerSocket serverSocket = new ServerSocket(this.port);
      this.socket = serverSocket.accept();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private BufferedReader inObj() {
    InputStreamReader r = new InputStreamReader(this.socket.getInputStream());
    return new BufferedReader(r);
  }

  private PrintWriter outObj() {
    return new PrintWriter(this.socket.getOutputStream(), true);
  }

  public postText(String text) {
    this.out.println(text);
  }

  public String getText() {
    return this.in.readLine();
  }

  public close() {
    this.in.close();
    this.out.close();
    this.socket.close();
  }
}
