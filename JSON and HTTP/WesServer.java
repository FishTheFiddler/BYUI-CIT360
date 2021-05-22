package MassEffectJSON;

import com.sun.net.httpserver.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class WesServer {

    public static void main(String[] args) {

        boolean running = false;
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8000), 0);
            server.createContext("/get_character_list", new CharacterHandler());
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
            server.setExecutor(threadPoolExecutor);
            server.start();
            System.out.println("Server started on port 8000");
            running = true;

            while (running) {
                System.out.println("Server is awaiting request.  ----  " + System.currentTimeMillis());
                Thread.sleep(5000);

            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error Connecting.");
        }
    }
}
