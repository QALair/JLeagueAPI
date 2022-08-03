package src.Runnables;

import src.Config.Connection;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Objects;

public class GetChampionsMastery {
    Connection connection = new Connection();

    public void getChampionsMastery(String SumName) throws IOException {
        String response;
        String EncUID;

        BufferedInputStream responseBuf;
        String responseMessage = null;

        GetEncryptedUID getUID = new GetEncryptedUID();

        EncUID = getUID.getEncryptedUIDBySumName(SumName);

        connection.MountRequiredConnectionConfiguration("/champion-mastery/v4/champion-masteries/by-summoner/"+EncUID);
        HttpURLConnection con = (HttpURLConnection) connection.getUrl().openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Riot-Token", connection.getMyRiotAPIToken());

        response = con.getResponseMessage();
        System.out.println(response);
        if (Objects.equals(response, "OK")){
            responseBuf = new BufferedInputStream(con.getInputStream());

            ByteArrayOutputStream bArrayStream = new ByteArrayOutputStream();
            int responseReader = responseBuf.read();
            while(responseReader != -1) {
                bArrayStream.write((byte) responseReader);
                responseReader = responseBuf.read();
            }
            responseMessage = bArrayStream.toString();
        }
        System.out.println(responseMessage);
    }
}

