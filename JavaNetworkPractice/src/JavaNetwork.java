import java.net.InetAddress;
import java.net.UnknownHostException;

public class JavaNetwork {
    public static void main(String[] args) {
        InetAddress ia;
        InetAddress[] iaArr;
        try {
            ia = InetAddress.getLocalHost();
            iaArr = InetAddress.getAllByName("www.naver.com");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ia);
        for (InetAddress remote : iaArr) {
            System.out.println("naver IP :" + remote.getHostAddress());
        }

    }
}
