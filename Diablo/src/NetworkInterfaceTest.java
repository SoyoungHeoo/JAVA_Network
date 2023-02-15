import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkInterfaceTest { // 기기에 연결되어 있는 네트워크 인터페이스 목록 출력하기
    public static void main(String[] args) {
        try{
        Enumeration<NetworkInterface> interfaceEnum =
                NetworkInterface.getNetworkInterfaces();
        System.out.println("Name    MAC Address");
        for (NetworkInterface element : Collections.list(interfaceEnum)) {
            System.out.printf("%-6s  %s\n", element.getName(), element.getDisplayName());
            Enumeration<InetAddress> addresses = element.getInetAddresses();
            Collections.list(addresses) // list 안에 열겨형 타입
                    .stream()
                    .forEach(
                            (inetAddress) ->
                            {
                                System.out.printf("IP 주소 : %s\n", inetAddress);
                            });
//            for (InetAddress inetAddress :
//                    Collections.list(addresses)) {
//                System.out.printf("    InetAddress: %s\n", inetAddress);
//            }


            }// end of for

        }catch(SocketException ex){
            System.out.print(ex);
        } // end of catch
    }
}
