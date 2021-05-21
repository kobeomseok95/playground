import java.io.IOException;
import java.net.ServerSocket;

public class Reactor {

    private ServerSocket serverSocket;
    private HandleMap handleMap;

    public Reactor(int port) {
        handleMap = new HandleMap();
        try {
            serverSocket = new ServerSocket(port);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
//        ThreadPerDispatcher threadPerDispatcher = new ThreadPerDispatcher();
        Dispatcher dispatcher = new ThreadPoolDispatcher();
        dispatcher.dispatch(serverSocket, handleMap);
    }

    public void registerHandler(String header, EventHandler handler) {
        handleMap.put(header, handler);
    }

    public void registerHandler(EventHandler eventHandler) {
        handleMap.put(eventHandler.getHandler(), eventHandler);
    }

    public void removeHandler(EventHandler eventHandler) {
        handleMap.remove(eventHandler.getHandler());
    }
}
