package src.config;

import java.net.MalformedURLException;
import java.net.URL;

public class Connection {
    private URL Url;
    private static final String MyRiotAPIToken = System.getenv("APIToken");

    public URL getUrl() {
        return Url;
    }

    public void setUrl(URL Url) {
        this.Url = Url;
    }

    public String getMyRiotAPIToken() {
        return MyRiotAPIToken;
    }

    public void MountRequiredConnectionConfiguration(String route) throws MalformedURLException {
        Url = new URL("https://br1.api.riotgames.com/lol"+route);
    }

    public Connection() {
    }
}
