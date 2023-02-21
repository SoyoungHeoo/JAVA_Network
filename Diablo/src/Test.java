import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

class One{
    private One(){

    }

    public static One produceOneInstance(){
        return new One();
    }

}

public class Test {
    public static String getMACIdentifier(NetworkInterface network){
        StringBuilder id = new StringBuilder();
        try{
            byte[] macBuffer = network.getHardwareAddress();
            if (macBuffer != null){
                for (int i = 0; i < macBuffer.length; i++){
                    id.append(String.format("%02X%s", macBuffer[i], (i<macBuffer.length - 1)? "-" : "")); // 삼항연산자 (출력 형식)
                    // id.append(String.format("%02X", macBuffer[i]);
                }
            }else{
                return "---";
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] agrs){
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("IP주소 : " + addr.getLocalAdress);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }// end of main
}
