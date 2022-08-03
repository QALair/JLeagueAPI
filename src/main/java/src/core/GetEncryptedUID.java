package src.core;

import org.json.*;
import src.config.Connection;
import src.utils.JLJsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.Objects;

public class GetEncryptedUID {
    private String EncryptedUid;
    Connection connection = new Connection();

    public String getEncryptedUid() {
        return EncryptedUid;
    }

    public void setEncryptedUid(String encryptedUid) {
        EncryptedUid = encryptedUid;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getEncryptedUIDBySumName(String SumName) throws IOException {
        String response;

        connection.MountRequiredConnectionConfiguration("/summoner/v4/summoners/by-name/"+SumName);
        HttpURLConnection con = (HttpURLConnection) connection.getUrl().openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Riot-Token", connection.getMyRiotAPIToken());

        response = con.getResponseMessage();

        if (Objects.equals(response, "OK")){
            JLJsonParser jparse = new JLJsonParser();
            EncryptedUid = jparse.parseJson(con.getInputStream(),"id");
        }
        return EncryptedUid;
    }


}
