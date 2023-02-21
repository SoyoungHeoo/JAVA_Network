import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCP_EchoServer {
    private static ServerSocket ss = null;// ServerSocket : 클라이언트와 데이터를 주고받기 위한 회선을 연결하는 객체. 우선 null로 초기화.
    private static ExecutorService ex = Executors.newFixedThreadPool(10);// 스레드풀 10개 생성

    public static void main(String[] args){
        System.out.println("서버를 종료하려면 Q 또는 q 를 누르시오 \n---------------\n");

    }

}
