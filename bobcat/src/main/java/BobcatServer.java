import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BobcatServer {

    private static final BobcatServer BOBCAT_SERVER = new BobcatServer();

    private HttpServer webServer;
    private ExecutorService threadPool;

    private BobcatServer() {


        try {
            // Initialize a web server and allocate a thread pool for handling incoming
            // requests. HTTP usually communicates over port 80 (for production) or
            // 8080 (for development). HTTPS is strictly over port 443.
            webServer = HttpServer.create(new InetSocketAddress(8080), 0);
            threadPool = Executors.newFixedThreadPool(5);
            webServer.setExecutor(threadPool);

            webServer.createContext("/test", (exchange) -> {

                if (!exchange.getRequestMethod().equals("GET")) return;

                String payload = "<h1>Test works!</h1>\n";
                payload += "<h2>This request was processed by thread: " + Thread.currentThread().getName() + "</h2>";
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, payload.length());
                exchange.getResponseBody().write(payload.getBytes(StandardCharsets.UTF_8));
            });

            webServer.createContext("/shutdown", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    shutdown();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startup() {
        webServer.start();
        System.out.println("Application server started and listening at http://localhost:8080");
    }

    public void shutdown() {
        System.out.println("Shutting down application server...");
        webServer.stop(5);
        threadPool.shutdownNow(); // necessary, otherwise the application does not terminate (since there are still active threads)
    }

    public static BobcatServer getInstance() {
        return BOBCAT_SERVER;
    }

}
