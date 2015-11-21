package org.vladyslav.goeuro.utils;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;

public class HttpUtils {

    public static final NetHttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    public static final JacksonFactory JSON_FACTORY = new JacksonFactory();

    private HttpUtils() {}

    public static <T> T executeJsonGetRequest(GenericUrl url, Class<T> dataClass) throws IOException {
        HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest request) throws IOException {
                request.setParser(new JsonObjectParser(JSON_FACTORY));
            }
        });
        HttpRequest request = requestFactory.buildGetRequest(url);
        HttpResponse response = request.execute();
        return response.parseAs(dataClass);
    }

}
