import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadPoolDispatcher implements Dispatcher {

    static final String NUMTHREADS = "8";
    static final String THREADPROP = "Threads";

    private int numThreads;

    public ThreadPoolDispatcher() {
        numThreads = Integer.parseInt(System.getProperty(NUMTHREADS, THREADPROP));
    }

    @Override
    public void dispatch(ServerSocket socket, HandleMap handleMap) {
        for (int i = 0; i < (numThreads - 1); i++) {
            Thread thread = new Thread() {
                public void run() {
                    dispatchLoop(socket, handleMap);
                }
            };

            thread.start();
            System.out.println("Created And Started Thread = " + thread.getName());
        }
        System.out.println("Iterative server starting in main thread " +
                Thread.currentThread().getName());
        dispatchLoop(socket, handleMap);
    }

    private void dispatchLoop(ServerSocket socket, HandleMap handleMap) {
        while (true) {
            try {
                Socket acceptSocket = socket.accept();
                Runnable demultiplexer = new Demultiplexer(acceptSocket, handleMap);
                demultiplexer.run();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
