import java.net.InetAddress;

public class findLocalIpAdd {    
    public static void main(String[] args) {
        try{
            InetAddress localhost = InetAddress.getLocalHost();

            String ipAddress = localhost.getHostAddress();

            System.out.println("Local IP Address : " +ipAddress);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
