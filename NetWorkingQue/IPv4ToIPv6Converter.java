import java.net.InetAddress;
import java.net.Inet6Address;
import java.net.UnknownHostException;

public class IPv4ToIPv6Converter {

    public static String convertIPv4ToIPv6(String ipv4) throws UnknownHostException {
        InetAddress ipv4Address = InetAddress.getByName(ipv4);

        if (!(ipv4Address instanceof Inet6Address)) {
            byte[] ipv4Bytes = ipv4Address.getAddress();
            byte[] ipv6Bytes = new byte[16];

            // IPv6-mapped IPv4 address: ::ffff:0:0
            // Fill first 10 bytes with 0, next 2 with 0xFF, and last 4 bytes with the IPv4 address
            ipv6Bytes[10] = (byte) 0xff;
            ipv6Bytes[11] = (byte) 0xff;
            System.arraycopy(ipv4Bytes, 0, ipv6Bytes, 12, ipv4Bytes.length);

            InetAddress ipv6Address = Inet6Address.getByAddress(null, ipv6Bytes, null);
            return ipv6Address.getHostAddress();
        }

        return ipv4Address.getHostAddress(); // return if it's already IPv6
    }

    public static void main(String[] args) {
        try {
            String ipv4 = "192.168.0.1";
            String ipv6 = convertIPv4ToIPv6(ipv4);
            System.out.println("IPv6 address: " + ipv6);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
