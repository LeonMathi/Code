import java.net.*;
public class UDPServer {
  public static void main(String[] a) throws Exception {
    var s = new DatagramSocket(5001);
    var b = new byte[100];
    while (true) {
      var p = new DatagramPacket(b, b.length); s.receive(p);
      var r = new DatagramPacket(p.getData(), p.getLength(), p.getAddress(), p.getPort());
      s.send(r);
    }
  }
}
