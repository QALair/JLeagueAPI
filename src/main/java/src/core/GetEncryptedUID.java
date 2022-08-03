package src.Runnables;

import org.json.*;
import src.Config.Connection;

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
        BufferedInputStream responseBuf;
        String responseMessage = null;

        connection.MountRequiredConnectionConfiguration("/summoner/v4/summoners/by-name/"+SumName);
        HttpURLConnection con = (HttpURLConnection) connection.getUrl().openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Riot-Token", connection.getMyRiotAPIToken());

        response = con.getResponseMessage();

        if (Objects.equals(response, "OK")){
            responseBuf = new BufferedInputStream(con.getInputStream());

            ByteArrayOutputStream bArrayStream = new ByteArrayOutputStream();
            int responseReader = responseBuf.read();
            while(responseReader != -1) {
                bArrayStream.write((byte) responseReader);
                responseReader = responseBuf.read();
            }
            responseMessage = bArrayStream.toString();

            JSONObject jsonResp = new JSONObject(responseMessage);
            EncryptedUid = jsonResp.getString("id");
        }
        return EncryptedUid;
    }


}
