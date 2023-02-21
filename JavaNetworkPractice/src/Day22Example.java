
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class Day22Example{
public static void main(String[]args) {
    System.out.println("Time Server started");
    try {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(20000));

        while (true) {
            System.out.println("Waiting for request...");
            SocketChannel sc = serverSocketChannel.accept();

            if (sc != null) {
                String dateAndTimeMessage = "Date: " + new Date(System.currentTimeMillis());
                ByteBuffer buf = ByteBuffer.allocate(64);
                buf.put(dateAndTimeMessage.getBytes());

                buf.flip();
                while (buf.hasRemaining()) {
                    try {
                        sc.write(buf);
                        System.out.println("Sent: " + dateAndTimeMessage);

                    } catch (IOException e) {throw new RuntimeException(e);}
                }// end of while(buf.hasRemaining))
                } // end of if

        } // end of while

    }catch(IOException ex){
        // Handle exceptions
        }

        }// end of main
        }

