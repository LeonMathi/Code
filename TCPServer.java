import java.net.*;
import java.io.*;
public class TCPServer {
  public static void main(String[] a) throws Exception {
    var s = new ServerSocket(5000);
    while (true) {
      var c = s.accept();
      var r = new BufferedReader(new InputStreamReader(c.getInputStream()));
      var w = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
      w.write("ACK: " + r.readLine() + "\n"); w.flush(); c.close();
    }
  }
}
