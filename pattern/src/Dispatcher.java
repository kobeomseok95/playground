import java.net.ServerSocket;

public interface Dispatcher {

    public void dispatch(ServerSocket socket, HandleMap handleMap);
}
