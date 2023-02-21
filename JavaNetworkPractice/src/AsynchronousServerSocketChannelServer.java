
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Future;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsynchronousServerSocketChannelServer {

    public AsynchronousServerSocketChannelServer() {
        System.out.println("Asynchronous Server Started");
        try (AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open())
        {
            InetSocketAddress hostAddress = new InetSocketAddress("localhost", 5000);
            serverChannel.bind(hostAddress);

            System.out.println("Waiting for client to connect... ");
            Future acceptResult = serverChannel.accept();

            try (AsynchronousSocketChannel clientChannel = (AsynchronousSocketChannel) acceptResult.get())
            {
                System.out.println("Messages from client: ");
                while ((clientChannel != null) && (clientChannel.isOpen())) {
                    ByteBuffer buffer = ByteBuffer.allocate(32);
                    Future result = clientChannel.read(buffer);
                    // Technique 1
//                    while (!result.isDone()) { // 하는 일 없이 계속 기다림
//                        // do nothing
//                    }
                    // Technique 2
//                    result.get(); // 그냥 받아버리거나
                    // Technique 3
                    result.get(7, TimeUnit.SECONDS); // 10초간 기다려보고 응답 없으면 패스. timeout 쓰려면 try catch 필수
                    buffer.flip();

                    String message = new String(buffer.array()).trim();
                    System.out.println(message);
                    if (message.equals("quit")) {
                        break;
                    }
                }
            } catch (TimeoutException e) {
                System.out.println("시간초과 예외 발생");
//                throw new RuntimeException(e);
            }
        } catch (IOException | InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
//        } catch (TimeoutException ex) {
//            // Used with get method when a timeout is specified
//            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AsynchronousServerSocketChannelServer();
    }

}