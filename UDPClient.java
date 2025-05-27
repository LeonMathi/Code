import java.net.*;
public class UDPClient {
  public static void main(String[] a) throws Exception {
    var s = new DatagramSocket();
    var m = "Hi UDP".getBytes();
    var addr = InetAddress.getByName("localhost");
    var p = new DatagramPacket(m, m.length, addr, 5001);
    long t = System.nanoTime(); s.send(p);
    var b = new byte[100]; s.receive(new DatagramPacket(b, b.length));
    System.out.println("RTT: " + (System.nanoTime() - t)/1e6 + " ms"); s.close();
  }
}
