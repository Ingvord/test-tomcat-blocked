package ru.ingvord.test;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Igor Khokhriakov <igor.khokhriakov@hzg.de>
 * @since 4/18/17
 */
public class TestClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://127.0.0.1:8080/test");

        while (true) {
            new Thread(() -> {
                try {
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    if (connection.getResponseCode() != 200) {
                        throw new RuntimeException("Operation failed: "
                                + connection.getResponseCode());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();

        }

    }
}
