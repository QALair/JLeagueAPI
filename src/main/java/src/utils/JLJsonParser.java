package src.utils;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class JLJsonParser {

    public String parseJson(InputStream streamObj, String elementToParse){
        JsonParser jsonParser = new JsonParser();
        JsonElement jElement = jsonParser.parse(new InputStreamReader((InputStream) streamObj));
        JsonObject rootobj = jElement.getAsJsonObject();
        String parsedElement = rootobj.get(elementToParse).getAsString();
        return parsedElement;
    }
}
