package com.example.L8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L8Application {

	/**
	 *
	 *     public static void main(String[] args) throws IOException {
	 *
	 *			server.setExecutorPool("")
	 *         server.createContext("/helloWorld", new HttpHandler() {
	 *             @Override
	 *             public void handle(HttpExchange exchange) throws IOException {
	 *                 String responseMessage = "Hi ... inside handle exchange - " + Thread.currentThread().getName();
	 *
	 *                 exchange.sendResponseHeaders(200, responseMessage.length());
	 *                 OutputStream responseBody = exchange.getResponseBody();
	 *                 responseBody.write(responseMessage.getBytes(StandardCharsets.UTF_8));
	 *             }
	 *         });

	 *     }
	 *
	 *
	 *
	 *
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(L8Application.class, args);
	}

}
