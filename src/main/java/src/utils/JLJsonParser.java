package src.utils;


import com.google.gson.JsonObject;

import java.io.InputStream;

public class JsonParser {

    public static String parseJson(InputStream streamObj){
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
        String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
    }
}
