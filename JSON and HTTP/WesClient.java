package MassEffectJSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.*;
import java.io.*;

public class WesClient {

    public static String getHttpContent(String string) {
        String content="";

        try {
            URL url = new URL(string);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line= reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            content = stringBuilder.toString();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return content;
    }

    public static Character JSONTOCharacter(String s) {
        ObjectMapper mapper= new ObjectMapper();
        Character character = null;
        try {
            character = mapper.readValue(s, Character.class);
        } catch(JsonProcessingException a){
            System.err.println(a.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return character;
    }

    public static void main(String[] args) {

        System.out.println("*---- Welcome to Week 4 assignment for CIT360 ----*");

        try {
            String jsonResponse = WesClient.getHttpContent("http://localhost:8000/get_character_list");
            Character character = JSONTOCharacter(jsonResponse);
            System.out.println(character);
        } catch (Exception e){
        }

    }
}
