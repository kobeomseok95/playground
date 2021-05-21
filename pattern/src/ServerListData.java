import org.simpleframework.xml.ElementList;

import java.util.List;

public class ServerListData {

    @ElementList(entry="server", inline=true)
    private List<HandlerListData> server;

    public List<HandlerListData> getServer() {
        return server;
    }
}
