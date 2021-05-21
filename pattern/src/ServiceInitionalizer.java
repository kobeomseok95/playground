import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.List;

public class ServiceInitionalizer {

    public static void main(String[] args) {
        int port = 8080;
        System.out.println("Server On! \nport = " + port);

        Reactor reactor = new Reactor(port);

        try {
            Serializer serializer = new Persister();
            File source = new File("HandlerList.xml");
            ServerListData serverListData = serializer.read(ServerListData.class, source);

            for (HandlerListData handlerListData : serverListData.getServer()) {

                if ("server1".equals(handlerListData.getName())) {
                    List<HandlerData> handlerList = handlerListData.getHandler();
                    for (HandlerData handler : handlerList) {
                        try {
                            reactor.registerHandler(handler.getHeader(), (EventHandler) Class.forName(handler.getHandler()).newInstance());
                        } catch(InstantiationException e) {
                            e.printStackTrace();
                        } catch(IllegalAccessException e) {
                            e.printStackTrace();
                        } catch(ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        reactor.startServer();
    }
}
