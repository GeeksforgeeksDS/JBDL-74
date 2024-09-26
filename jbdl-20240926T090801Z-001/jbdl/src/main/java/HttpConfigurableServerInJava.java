import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpConfigurableServerInJava {


    /**
     *  Redis --> redis single threaded or multithreaded
     *  Hashmap
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8090), 0);
        server.setExecutor(Executors.newFixedThreadPool(5));


        server.createContext("/helloWorld", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String responseMessage = "Hi ... inside handle exchange - " + Thread.currentThread().getName();

                exchange.sendResponseHeaders(200, responseMessage.length());
                OutputStream responseBody = exchange.getResponseBody();
                responseBody.write(responseMessage.getBytes(StandardCharsets.UTF_8));
            }
        });
        server.start();
    }
}
