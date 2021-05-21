import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class EchoHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;

    public EchoHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {

        if (result == -1) {
            try {
                channel.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else if (result > 0) {
            attachment.flip();

            String msg = new String(attachment.array());
            System.out.println("echo : " + msg);
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }
}
