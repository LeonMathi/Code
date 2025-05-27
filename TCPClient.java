import java.net.*;
import java.io.*;
public class TCPClient {
  public static void main(String[] a) throws Exception {
    long t = System.nanoTime();
    var c = new Socket("localhost", 5000);
    var w = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
    var r = new BufferedReader(new InputStreamReader(c.getInputStream()));
    w.write("Hi TCP\n"); w.flush(); System.out.println(r.readLine());
    System.out.println("RTT: " + (System.nanoTime() - t)/1e6 + " ms"); c.close();
  }
}
