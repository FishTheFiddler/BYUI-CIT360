package MassEffectJSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class CharacterHandler implements HttpHandler {

    public String characterToJSON(Character character){
        ObjectMapper mapper = new ObjectMapper();
        String s = "";
        try {
            s = mapper.writeValueAsString(character);
        } catch(JsonProcessingException a){
            System.err.println(a.toString());
        }
        return s;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        if("GET".equals(httpExchange.getRequestMethod())) {
            System.out.println("-GET Request Received-");
        }

        else if("POST".equals(httpExchange)) {
            System.out.println("-POST Request Received-");
        }

        handleResponse(httpExchange);
    }

    private void handleResponse(HttpExchange httpExchange)  throws  IOException {

        OutputStream outputStream = httpExchange.getResponseBody();

        Character shepard = new Character();

        shepard.setName("Commander Shepard");
        shepard.setSpecies("Human");
        shepard.setAppearance(1);
        shepard.setIsMale(true);

        String characters = characterToJSON(shepard);
        String jsonResponse = characters.toString();

        httpExchange.getResponseHeaders().set("Content-Type", "text/json");
        httpExchange.sendResponseHeaders(200, jsonResponse.length());
        outputStream.write(jsonResponse.getBytes());
        outputStream.flush();
        outputStream.close();

    }

}

