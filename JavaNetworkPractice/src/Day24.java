import java.net.InetAddress;
import java.net.UnknownHostException;
public class Day24 {
    public static void main(String[] args) {
        InetAddress address = null;
        InetAddress names[] = new InetAddress[0];
        try {
            names = InetAddress.getAllByName("www.naver.com");
            for(InetAddress element : names){
                System.out.println(element);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        try {
            address = InetAddress.getByName("www.ibm.com");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
//        displayInetAddressInformation(address);
    }
}
