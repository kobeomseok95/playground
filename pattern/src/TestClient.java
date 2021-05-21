import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TestClient {

    public static void main(String[] args) {
        System.out.println("Client On");

        try {
            String msg;
            Socket socket = new Socket("127.0.0.1", 8080);
            OutputStream outputStream = socket.getOutputStream();
            msg = "0x5001|홍길동|22";
            outputStream.write(msg.getBytes());
            socket.close();

            Socket socket2 = new Socket("127.0.0.1", 8080);
            OutputStream outputStream2 = socket2.getOutputStream();
            msg = "0x6001|hong|1234|홍길동|22|남성";
            outputStream2.write(msg.getBytes());
            socket2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
